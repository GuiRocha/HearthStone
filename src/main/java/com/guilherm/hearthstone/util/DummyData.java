package com.guilherm.hearthstone.util;

import com.guilherm.hearthstone.model.Carta;
import com.guilherm.hearthstone.model.Classe;
import com.guilherm.hearthstone.model.Tipo;
import com.guilherm.hearthstone.repository.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
public class DummyData implements CommandLineRunner {
    @Autowired
    private CartaRepository cartaRepository;
    @Override

    public void run(String... args) throws Exception {
        cartaRepository.deleteAll();
        Carta mago = new Carta(null, "bla", "blabla",10,10, Tipo.MAGIA, Classe.CACADOR);
        Carta negro = new Carta(null, "Mago negro", "Joao bla bla bla",10,10, Tipo.CRIATURA, Classe.QUALQUER);

        cartaRepository.saveAll(Arrays.asList(mago, negro));
    }
}
