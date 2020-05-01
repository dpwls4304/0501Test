package t0501;

public class DBInsert extends DBConImpl{
	
	public String name;
	public String chat;
	
	public DBInsert() {
		
	}
	
	public DBInsert(String name, String chat) {
		super("kosmo", "1234");
		this.name = name;
		this.chat = chat;
	}
	
	@Override
	public void execute() {
		try {
			String query = "INSERT INTO chatting_tb VALUES(cahtting_seq.nextval, ?, ?, sysdate)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setString(2, chat);
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 업로드 되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
}
