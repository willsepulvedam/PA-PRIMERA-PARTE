import java.util.ArrayList;

public class GestorCategorias {
    private ArrayList<Categoria> categorias;

    public GestorCategorias() {
        categorias = new ArrayList<>();
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void listarCategorias() {
        for (Categoria c : categorias) {
            System.out.println(c);
        }
    }

    public void actualizarCategoria(int id, String nuevoNombre) {
        Categoria categoria = buscarCategoria(id);
        if (categoria != null) {
            categoria.setNombre(nuevoNombre);
            System.out.println("Categoría actualizada.");
        } else {
            System.out.println("Categoría no encontrada.");
        }
    }

    public void eliminarCategoria(int id) {
        categorias.removeIf(c -> c.getId() == id);
        System.out.println("Categoría eliminada.");
    }

    public Categoria buscarCategoria(int id) {
        for (Categoria c : categorias) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}

