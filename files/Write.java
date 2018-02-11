import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;

public class Write {
    
    public void serializeDatabase(Database database) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

            fout = new FileOutputStream(".\\database\\database.ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(database);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    
    public void serializeHighscores(Highscore highscore) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

            fout = new FileOutputStream(".\\database\\highscore.ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(highscore);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    
    public void serializeQuiz(Quiz quiz) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        File currentFolder = new File(".\\database");
        File workingFolder = new File(currentFolder, "quizes");
        if (!workingFolder.exists()) {
            workingFolder.mkdir();
        }      
        System.out.println(workingFolder.getAbsolutePath());
        
        try {
            
            File currentFolder1 = new File(".\\database\\quizes");
            File workingFolder1 = new File(currentFolder1, "quiz" + quiz.getNumber());
            if (!workingFolder1.exists()) {
                workingFolder1.mkdir();
            }
            System.out.println(workingFolder.getAbsolutePath());
            
            fout = new FileOutputStream(".\\database\\quizes\\quiz" + quiz.getNumber() + "\\quiz" + quiz.getNumber() + ".ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(quiz);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    
    public void serializeQuestion(Question question, Quiz quiz) {
        int quizNumber = quiz.getNumber();
        
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        
        File currentFolder = new File(".\\database\\quizes\\quiz" + quizNumber);
        File workingFolder = new File(currentFolder, "questions");
        if (!workingFolder.exists()) {
            workingFolder.mkdir();
        }       
        System.out.println(workingFolder.getAbsolutePath());

        try {
            
            fout = new FileOutputStream(".\\database\\quizes\\quiz" + quizNumber +"\\questions\\question" + question.getNumber() + ".ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(question);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}