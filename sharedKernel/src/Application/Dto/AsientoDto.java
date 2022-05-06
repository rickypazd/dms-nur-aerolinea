package Application.Dto;

import java.util.UUID;

public class AsientoDto {
    private UUID keyAeronave;
    private int numero;
    private String clase;


    public AsientoDto() {
    }

    public AsientoDto(UUID keyAeronave, int numero, String clase) {
        this.keyAeronave = keyAeronave;
        this.numero = numero;
        this.clase = clase;
    }


    public UUID getKeyAeronave() {
        return this.keyAeronave;
    }

    public void setKeyAeronave(UUID keyAeronave) {
        this.keyAeronave = keyAeronave;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getClase() {
        return this.clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}
