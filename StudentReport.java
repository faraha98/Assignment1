   import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class StudentReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter department file name (e.g. CS.txt): ");
        String deptFileName = scanner.nextLine().trim();
        System.out.print("Enter course file name (e.g. hedva.txt): ");
        String courseFileName = scanner.nextLine().trim();
        String reportFileName = "report.txt";
       
        
        try (
            BufferedReader brDept = new BufferedReader(new FileReader(deptFileName));
            BufferedReader brCourse = new BufferedReader(new FileReader(courseFileName));
            PrintWriter pwReport = new PrintWriter(new FileWriter(reportFileName))
        ) {
            String lineDept = brDept.readLine();
            String lineCourse = brCourse.readLine();
            while (lineDept != null && lineCourse != null) {
                lineDept = lineDept.trim();
                lineCourse = lineCourse.trim();
                if (lineDept.isEmpty()) {
                    lineDept = brDept.readLine();
                    continue;
                }
                if (lineCourse.isEmpty()) {
                    lineCourse = brCourse.readLine();
                    continue;
                }

                String[] deptParts = lineDept.split("\\s+");
                String idDept = deptParts[deptParts.length - 1];

                String[] courseParts = lineCourse.split("\\s+");
                String idCourse = courseParts[0];

                long numDept = Long.parseLong(idDept);
                long numCourse = Long.parseLong(idCourse);
                if (numDept == numCourse) {
                   
                    String firstName = deptParts[0];
                    String lastName = deptParts[1];
                    if (deptParts.length > 3) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < deptParts.length - 1; i++) {
                            if (sb.length() > 0) sb.append(" ");
                            sb.append(deptParts[i]);
                        }
                        lastName = sb.toString();
                    }
                    int grade1 = Integer.parseInt(courseParts[1]);
                    int grade2 = Integer.parseInt(courseParts[2]);
                    double avg = (grade1 + grade2) / 2.0;
                    // Whole numbers formatted without decimal (e.g. 80, 88)
                    String avgFormatted = (avg == (long) avg) ? String.valueOf((long) avg) : String.valueOf(avg);
                    pwReport.println(idDept + " " + firstName + " " + lastName + " " + avgFormatted);
                    // Advance both files
                    lineDept = brDept.readLine();
                    lineCourse = brCourse.readLine();
                } else if (numDept < numCourse) {

                    lineDept = brDept.readLine();
                } else {

                    lineCourse = brCourse.readLine();
                }
            }
            System.out.println("Report successfully created at: " + reportFileName);
        } catch (IOException e) {
            System.err.println("File I/O error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}