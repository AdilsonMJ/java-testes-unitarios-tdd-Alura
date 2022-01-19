package service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    @Test
    public void reajusteDeveriaSerDe3PorcentoComDesempenhoADesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("adilson", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assert.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveriaSerDe15PorcentoComDesempenhoBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("adilson", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.BOM);
        Assert.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe20PorcentoComDesempenhoOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("adilson", LocalDate.now(), new BigDecimal("1000"));
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        Assert.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
