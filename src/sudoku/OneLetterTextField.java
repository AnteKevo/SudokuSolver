package sudoku;

import javafx.scene.control.TextField;

public class OneLetterTextField extends TextField { //Used in the textField to make sure that you can only write values between 1-9

	@Override
	public void replaceText(int start, int end, String text) {
		if (matches(text)) {
			super.replaceText(start, end, text);
		}
	}
	
	@Override
	public void replaceSelection(String text) {
		if (matches(text)) {
			super.replaceSelection(text);
		}
	}

	private boolean matches(String text) {
		return text.isEmpty() || (getText().length() < 1) && text.matches("[1-9]") ;
	}

}