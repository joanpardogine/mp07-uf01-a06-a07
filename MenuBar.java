import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

// Clase que generaliza la barra de menús
public class MenuBar {

    private JMenuBar menuBar;

    // Constructor que recibe la estructura del menú
    public MenuBar(Map<String, String[]> menuStructure) {
        menuBar = new JMenuBar();

        // Iterar sobre la estructura del menú y agregar menús y opciones
        for (Map.Entry<String, String[]> entry : menuStructure.entrySet()) {
            String menuText = entry.getKey();
            String[] menuItems = entry.getValue();
            addMenu(menuText, menuItems);
        }
    }

    // Método privado para añadir un menú y sus opciones
    private void addMenu(String menuText, String[] menuItems) {
        JMenu menu = new JMenu(menuText);

        // Iterar sobre las opciones del menú y agregarlas
        for (String menuItemText : menuItems) {
            JMenuItem menuItem = new JMenuItem(menuItemText);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(menuItemText + " seleccionado");
                }
            });
            menu.add(menuItem);
        }

        menuBar.add(menu);
    }

    // Método para obtener la barra de menús
    public JMenuBar getMenuBar() {
        return menuBar;
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        // Estructura del menú
        Map<String, String[]> menuStructure = new HashMap<>();
        menuStructure.put("Archivo", new String[]{"Abrir", "Guardar", "Salir"});
        menuStructure.put("Editar", new String[]{"Copiar", "Pegar", "Deshacer"});

        // Crear la barra de menús con la estructura proporcionada
        MenuBar menuBar = new MenuBar(menuStructure);

        // Crear el marco principal y añadir la barra de menús
        JFrame frame = new JFrame("Ejemplo de Barra de Menús");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setJMenuBar(menuBar.getMenuBar());
        frame.setVisible(true);
    }
}
