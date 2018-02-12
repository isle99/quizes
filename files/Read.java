import java.io.*;

public class Read {
    
	public Database deserialzeDatabase(String filename) {

		Database database = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			database = (Database) ois.readObject();
		} catch (Exception ex) {
		    
			ex.printStackTrace();
		} finally {

			if (fin != null) {
			    
				try {
				    
					fin.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}

			if (ois != null) {
			    
				try {
					ois.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}

		}

		return database;

	}
	
	public Highscore deserialzeHighscore(String filename) {

		Highscore highscore = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			highscore = (Highscore) ois.readObject();
		} catch (Exception ex) {
		    
			ex.printStackTrace();
		} finally {

			if (fin != null) {
			    
				try {
				    
					fin.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}
			if (ois != null) {
			    
				try {
				    
					ois.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}
		}

		return highscore;
	}
	
	public Quiz deserialzeQuiz(String filename) {

		Quiz quiz = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			quiz = (Quiz) ois.readObject();
		} catch (Exception ex) {
		    
			ex.printStackTrace();
		} finally {

			if (fin != null) {
			    
				try {
				    
					fin.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}
			if (ois != null) {
			    
				try {
					ois.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}
		}

		return quiz;
	}
	
	public Question deserialzeQuestion(String filename) {

		Question question = null;
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try {

			fin = new FileInputStream(filename);
			ois = new ObjectInputStream(fin);
			question = (Question) ois.readObject();
		} catch (Exception ex) {
		    
			ex.printStackTrace();
		} finally {

			if (fin != null) {
			    
				try {
				    
					fin.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}
			if (ois != null) {
			    
				try {
				    
					ois.close();
				} catch (IOException e) {
				    
					e.printStackTrace();
				}
			}
		}

		return question;
	}
}