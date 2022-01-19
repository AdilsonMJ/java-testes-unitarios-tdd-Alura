package service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaLancarErroExceptionPorCausaDoSalarioSuperiorADezMil() throws Exception {
        BonusService service = new BonusService();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Adilson", LocalDate.now(), new BigDecimal(30000))));

    };

    @Test
    public void bonusDeveriaRetornaValorDoBonus() throws Exception {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Adilson", LocalDate.now(), new BigDecimal(1000)));


        Assertions.assertEquals(new BigDecimal("100.00"), bonus);

    }

    @Test
    public void bonusSeOValorForIgualAoLimite() throws Exception {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Adilson", LocalDate.now(), new BigDecimal(10000)));

        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);

    }
}