package com.example.prak.Services;

import com.example.prak.Entities.Student;
import com.example.prak.Entities.Users;
import com.example.prak.Repositories.UserRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class ReadWordService {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserRepository userRepository; // Внедрение UserRepository


    public void ReadDocument(HttpServletResponse response, Principal principal, int id) throws IOException {
        List<Student> stud = studentService.findAll();

        String path = "C:\\Users\\dmitr\\OneDrive\\Рабочий стол\\college\\firstCommit\\prak\\prak\\src\\main\\resources\\static\\report_template.docx";

        FileInputStream fis = new FileInputStream(path);
        XWPFDocument document = new XWPFDocument(fis);

        for (XWPFParagraph paragraph : document.getParagraphs()) {
            replacePlaceholders(paragraph, stud, id, principal);
        }

        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        replacePlaceholders(paragraph, stud, id, principal);
                    }
                }
            }
        }

        response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        response.setHeader("Content-Disposition", "attachment; filename=users.docx");

        // Write the document to the response output stream
        try (ServletOutputStream out = response.getOutputStream()) {
            document.write(out);
            out.flush();
        } catch (IOException e) {
            log.error("Error writing document to output stream", e);
        } finally {
            fis.close();
        }
    }

    @Autowired
     private UserService userService;
    private void replacePlaceholders(XWPFParagraph paragraph, List<Student> students, int id, Principal principal) {
        String pText = paragraph.getText();

        if (!students.isEmpty() && id < students.size()) {
            Student student = students.get(id);
            Users user = userService.getUserByPrincipal(principal);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String birthdate = student.getBirthdate().format(formatter);
            pText = pText.replace("$UserName", user.getUsername()); // Предполагается, что у пользователя есть метод getName()
            pText = pText.replace("$StudentFirstName", student.getFirstname());
            pText = pText.replace("$StudentMiddleName", student.getMiddlename());
            pText = pText.replace("$StudentLastName", student.getLastname());
            pText = pText.replace("$PhoneNumber", student.getPhonenumber());
            pText = pText.replace("$Email", student.getEmail());
            pText = pText.replace("$Residance", student.getResidence());
            pText = pText.replace("$Birthdate", birthdate);
            pText = pText.replace("$Status", student.getStatus());
        }

        for (int pos = paragraph.getRuns().size() - 1; pos >= 0; pos--) {
            paragraph.removeRun(pos);
        }

        XWPFRun run = paragraph.createRun();
        run.setText(pText);
    }
}
