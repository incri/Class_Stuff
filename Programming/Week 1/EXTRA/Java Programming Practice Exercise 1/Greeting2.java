import javax.swing.*;

public class Greeting2 {
public static void main(String[] args) {

JFrame jFrame = new JFrame();

String[][] tableData = {{"Good morning.", "शुभ - प्रभात।"},
{"It is a pleasure to meet you.", "तपाईलाई भेट्न पाउँदा खुसी लाग्यो।"},
{"Please call me tomorrow.", "कृपया मलाई भोलि कल गर्नुहोस्।"},
{"Have a nice day!", "हजुर को दिन राम्रो होस्!"}};

String[] tableColumn = {"English", "Nepali"};

JTable jTable = new JTable(tableData, tableColumn);

jTable.setBounds(30, 40, 230, 280);

JScrollPane jScrollPane = new JScrollPane(jTable);
jFrame.add(jScrollPane);
jFrame.setSize(350, 300);
jFrame.setVisible(true);
}
}
