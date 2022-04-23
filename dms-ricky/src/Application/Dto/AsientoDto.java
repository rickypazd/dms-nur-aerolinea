package Application.Dto;

import java.util.UUID;

public class AsientoDto {
    private UUID keyAeronave;
    private int numero;
    private String clase;

    public void setKeyAeronave(UUID keyAeronave) {
        this.keyAeronave = keyAeronave;
    }

    public UUID getKeyAeronave() {
        return keyAeronave;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getClase() {
        return clase;
    }
}
