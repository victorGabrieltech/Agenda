
package model;

/**
 * @since 28/10/24
 * @author 2975
 */
public class Contatos {
    
    // atributos da classe
    private int ID;
    private String sNome;
    private String sEndereco;
    private String sTelefone;
    private char cSexo;
    private String sEmail;
    
    // construtor padrão da classe
    public Contatos() {
    }
    
    // construtor parametrizado
    public Contatos(String sNome, String sEndereco, String sTelefone, char cSexo, String sEmail) {
        this.sNome = sNome;
        this.sEndereco = sEndereco;
        this.sTelefone = sTelefone;
        this.cSexo = cSexo;
        this.sEmail = sEmail;
    }
    
    // métodos getter´s e setter´s
    public int getID() { return ID; }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getsNome() { return sNome; }
    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    public String getsEndereco() { return sEndereco; }
    public void setsEndereco(String sEndereco) {
        this.sEndereco = sEndereco;
    }

    public String getsTelefone() { return sTelefone; }
    public void setsTelefone(String sTelefone) {
        this.sTelefone = sTelefone;
    }

    public char getcSexo() { return cSexo; }
    public void setcSexo(char cSexo) {
        this.cSexo = cSexo;
    }

    public String getsEmail() { return sEmail; }
    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa{");
        sb.append("ID=").append(ID);
        sb.append(", sNome=").append(sNome);
        sb.append(", sEndereco=").append(sEndereco);
        sb.append(", sTelefone=").append(sTelefone);
        sb.append(", cSexo=").append(cSexo);
        sb.append(", sEmail=").append(sEmail);
        sb.append('}');
        return sb.toString();
    }

  
    
    
}
