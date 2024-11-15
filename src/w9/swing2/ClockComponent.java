package w9.swing2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class ClockComponent extends JLabel {
	ClockComponent() {
		super("", SwingConstants.CENTER);
		Timer t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setText(getTimeString());
			}
		});
		setFont(new Font("Sans Serif", Font.PLAIN, 24));
		t.start();
	}

	String getTimeString() {
		int hour, minute, second;
		Calendar rite = Calendar.getInstance();
		hour = rite.get(Calendar.HOUR_OF_DAY);
		minute = rite.get(Calendar.MINUTE);
		second = rite.get(Calendar.SECOND);
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 50);
	}
}