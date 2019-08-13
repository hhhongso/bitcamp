package bitProject.cafe.view;
// 이미 존재하는 JFrame에서 또 JFrame을 사용하는 것보다는 JDialog를 사용하는 것이 더 낫다고 판단했습니다

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bitProject.cafe.dao.Status;
import bitProject.cafe.dto.BoardDTO;

public class BoardDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 19310253510009307L;
	private JPanel pnlMain, btnPane;
	private JLabel lblId, lblId2, lblText;
	private JTextField tfText;
	private JButton btnWrite, btnCancle;

	private ClientFrame main;
	private Board board;

	public BoardDialog(ClientFrame main, Board board) {
		this.main = main;
		this.board = board;

		// 라벨
		lblId = new JLabel("작성자");
		lblId.setBounds(43, 26, 57, 15);

		lblText = new JLabel("내용");
		lblText.setBounds(53, 63, 57, 15);

		lblId2 = new JLabel(board.getMember().getId()); // MemberDTO의 ID를 받아온다
		lblId2.setBounds(117, 26, 57, 15);

		// 게시글 내용 입력 받기
		tfText = new JTextField();
		tfText.setBounds(117, 57, 282, 27);
		tfText.setColumns(10);

		// 패널 처리
		pnlMain = new JPanel();
		pnlMain.setLayout(null);
		pnlMain.setBounds(0, 0, 434, 101);

		pnlMain.add(tfText);
		pnlMain.add(lblId);
		pnlMain.add(lblText);
		pnlMain.add(lblId2);

		// 작성/취소 버튼
		btnWrite = new JButton("작성");
		btnWrite.setActionCommand("OK");
		btnCancle = new JButton("취소");
		btnCancle.setActionCommand("Cancel");

		btnPane = new JPanel();
		btnPane.add(btnWrite);
		btnPane.add(btnCancle);
		btnPane.setBounds(0, 99, 434, 38);
		btnPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		getContentPane().setLayout(null);
		getContentPane().add(pnlMain);
		getContentPane().add(btnPane);

		setBounds(100, 100, 445, 176);
		setResizable(false);
		setVisible(true);

		getRootPane().setDefaultButton(btnWrite); // Enter를 치면 btnConfirm을 입력한 것으로 처리(엔터치면 작성 됩니다)
		btnWrite.addActionListener(this);
		btnCancle.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String writeTime = sdf.format(cal.getTime());

		if (e.getSource() == btnWrite) { // 쓰기 버튼 클릭했을 때 처리.
			String text = tfText.getText();
			if (text.length() < 1) {
				JOptionPane.showMessageDialog(this, "글을 입력해주세요.");
			} else {
				try {
					BoardDTO boardDTO = new BoardDTO(board.getMember().getId(), text, writeTime);
					boardDTO.setStatus(Status.WRITE_BOARD);
					main.getOos().writeObject(boardDTO);
					main.getOos().flush();

					while (true) {
						Object objectRecieved = null;
						try {
							objectRecieved = main.getOis().readObject();
						} catch (EOFException e1) {
							objectRecieved = null;
						}
						if (objectRecieved instanceof BoardDTO) {
							boardDTO = (BoardDTO) objectRecieved;
							if (boardDTO.getStatus() == Status.WRITE_BOARD) {
								for (int i = 0; i < board.getModelBoardList().getRowCount(); i++) { // 전부삭제
									board.getModelBoardList().removeRow(i);
									i--;
								}
								board.setBoardList(boardDTO.getBoardList());
								for (int i = 0; i < board.getBoardList().size(); i++) { // Board쪽에 DB에서 가져온 모든 것을 업데이트.
									board.getModelBoardList().addRow(board.getBoardList().get(i));
								}
							}
							setVisible(false);
							return;
						} else {
							return;
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}

//			if (!text.equals("")) { // 공백을 입력하지 않았을 때
//				BoardDTO dto = new BoardDTO();
//				dto.setSeq("0"); // 임시로 0으로 해놓았습니다. DB에서 시퀀스를 받아서 줄 수 있다면 좋겠습니다
//				dto.setText(text);
//				dto.setId(member.getId());
//				dto.setDateWrite(writeTime);
//
//				listBoard.add(dto); // BoardDTO 객체를 가지고 있는 ArrayList입니다. DB연결 때는 이걸 이용하세요
//
//				vList = new Vector<Object>(); // JTable에는 열 별로 vector로 추가한다.
//				vList.addElement(dto.getSeq());
//				vList.addElement(dto.getText());
//				vList.addElement(dto.getId());
//				vList.addElement(dto.getDateWrite());
//				model.addRow(vList);
//
//				setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				setVisible(false);
//			} else {
//				JOptionPane.showMessageDialog(this, "내용을 입력하지 않았습니다", "게시물 작성 오류", JOptionPane.WARNING_MESSAGE);
//			}
		} else if (e.getSource() == btnCancle) {
			setVisible(false);
		}
	}
}
