package calculator;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
public class Calculator extends JFrame 
implements ActionListener{
	int num1, num2, result;
	String oper;
	JTextField text;
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		switch(input) {
		case "+": case "-": case "*": case "/":
			if(text.getText() != "") {
				num1 = Integer.parseInt(text.getText());
				text.setText("");
				text.getText();
			}
			oper = input;
			break;
		case "C":
			text.setText("");
			break;
		case "=":
			if(text.getText() != "") {
				num2 = Integer.parseInt(text.getText());
			}
			if(oper.equals("+")) {
				result = num1 + num2;
			}
			else if(oper.equals("-")) {
				result = num1 - num2;
			}
			else if(oper.equals("*")) {
				result = num1 * num2;
			}
			else if(oper.equals("/")) {
				result = num1 / num2;
			}
			String output = Integer.toString(result);
			text.setText(output);
			oper = "";
			break;
		default :
			text.setText(text.getText() + input);
			break;
		}
		
	}
	public Calculator(){ //생성자 생성
		setLocationRelativeTo(null);
		setTitle("계산기");
		setSize(400,300);
		text = new JTextField("",20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();//참조형타입
		panel1.add(text);
		String[] num_op = { "C", "=", "+", "-", 
							"*", "1", "2", "3",
							"/", "4", "5", "6",
							"0", "7", "8", "9"};
		JButton button[] = new JButton[16];
		panel2.setLayout(new GridLayout(4,4,10,10));//setLayout으로 레이아웃 변경
		for(int i=0; i<num_op.length; i++){
			button[i] = new JButton(num_op[i]);
			panel2.add(button[i]);
			button[i].addActionListener(this);//addActionListener를 구현하는 놈은 this이고 button[i]너는 마 액션리스너가 되는거야! 
			
		}
		add(panel1,BorderLayout.NORTH);//덮어씌어지지않게 잘하자
		add(panel2,BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator();//인스턴스 만들기
	}
	//클래스로 여러개로 나누어 보기 객체지향!
	//중복코드 정리
	//개선 할 점 : 연산자 연속으로 누르면 에러남, 소수점도 계산하기
}
