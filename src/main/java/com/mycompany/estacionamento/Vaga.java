package com.mycompany.estacionamento;
import java.util.ArrayList;

public class Vaga {
    public static int id;
    private Patio patio;
    private VagaEstado estadoVagaEsq, estadoVagaDir;
    private Veiculo veiculoEsq, veiculoDir;
    ArrayList<Estacionada> estacionadas = new ArrayList<>();

    public Vaga(Patio patio){
        id++;
        this.patio = patio;
        this.estadoVagaEsq = VagaEstado.DISPONIVEL;
        this.estadoVagaDir = VagaEstado.DISPONIVEL;
    }
    
    public int getId(){
        return id;
    }
    
    public Patio getPatio(){
        return patio;
    }
    
    public int getEstado(){
        if (estadoVagaEsq == VagaEstado.DISPONIVEL && estadoVagaDir == VagaEstado.DISPONIVEL)
        {
            return 0; //Retorna 0 se a vaga NÃO está ocupada
        }
        else if (estadoVagaEsq == VagaEstado.INDISPONIVEL && estadoVagaDir == VagaEstado.INDISPONIVEL){
            return 2; //Retorna 2 se a vaga está ocupada por um Carro ou por duas Motos
        }
        else
        {
            return 1; //Retorna 1 se a vaga está ocupada por uma Moto
        }
    }
    
    public ArrayList getEstacionadas(){
        return estacionadas;
    }
    
    public void ocupar(Estacionada estacionada){
        int teste = getEstado();
        
        if (teste == 0)
        {
            this.veiculoEsq = estacionada.getVeiculo();
            if (veiculoEsq instanceof Carro){
                this.estadoVagaEsq = VagaEstado.INDISPONIVEL;
                this.estadoVagaDir = VagaEstado.INDISPONIVEL;
            }
            else
            {
                this.estadoVagaEsq = VagaEstado.INDISPONIVEL;
            }
        }
        else
        {
            if (estadoVagaEsq == VagaEstado.DISPONIVEL)
            {
                this.veiculoEsq = estacionada.getVeiculo();
                this.estadoVagaEsq = VagaEstado.INDISPONIVEL;
            }
            else
            {
                this.veiculoDir = estacionada.getVeiculo();
                this.estadoVagaDir = VagaEstado.INDISPONIVEL;
            }
        }
        estacionadas.add(estacionada);
    }
    
    public void liberar(Estacionada estacionada){
        int teste = getEstado();
        if (teste == 1){
            if (estadoVagaEsq == VagaEstado.INDISPONIVEL)
            {
                estadoVagaEsq = VagaEstado.DISPONIVEL;
                veiculoEsq = null;
            }
            else
            {
                estadoVagaDir = VagaEstado.DISPONIVEL;
                veiculoDir = null;
            }   
        }
        else
        {
                estadoVagaEsq = VagaEstado.DISPONIVEL;
                estadoVagaDir = VagaEstado.DISPONIVEL;
                veiculoEsq = null;
        }
        }
    }
}

