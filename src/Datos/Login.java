package Datos;

public class Login {

    private int id;
    private String usuario;
    private String password;
    private int estado;
    private int idPersonal;

    public Login() {
    }

    public Login(int id, String usuario, String password, int idPersonal, int estado) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.idPersonal = idPersonal;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
