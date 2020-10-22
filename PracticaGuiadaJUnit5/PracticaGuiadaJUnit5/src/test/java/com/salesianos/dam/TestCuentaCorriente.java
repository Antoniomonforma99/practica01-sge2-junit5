package com.salesianos.dam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestCuentaCorriente {

    static CuentaCorriente cuenta;
    static CuentaCorriente cuenta2;

    @BeforeAll
    static void init(){
        cuenta = new CuentaCorriente("Antonio", 123456789, 100000);
        cuenta2 = new CuentaCorriente("Antonio", 123456789, 100000);

        System.out.println("Instancia de cuenta creada");
    }

    @Test
    @DisplayName("DepositoTrue")
    void depositoTrue(){
        assertEquals(true, cuenta.deposit(2), "Su deposito es de 100002 euros");
    }

    @Test
    @DisplayName("DepostitoFalse")
    void depositoFalse(){
        assertEquals(false, cuenta.deposit(-5), "Ha introducido una cantidad negativa");
    }

    @Test
    @DisplayName("WithdrawTrue")
    void withdrawTrue(){
        assertEquals(true, cuenta.withdraw(20, 2), "Retirada efectuada con éxito");
    }

    @Test
    @DisplayName("WithdrawFalseAmountNegativo")
    void withdrawFalseAmountNegativo(){
        assertEquals(false, cuenta.withdraw(-10, 2), "La cantidad a retirar es negativa");
    }

    @Test
    @DisplayName("WithdrawFalseFeeNegativo")
    void withdrawFalseFeeNegativo(){
        assertEquals(false, cuenta.withdraw(10, -2), "El impuesto es negativo");
    }

    @Test
    @DisplayName("WithdrawFalseAmountMayorQueSaldo")
    void withdrawFalseAmountMayorQueSaldo(){
        assertEquals(false, cuenta.withdraw(10000005, 2), "La cantidad a retirar es mayor que el saldo") ;
    }

    @Test
    @DisplayName("AddInterest")
    void addInterestTest(){
        cuenta.addInterest();
        assertNotEquals(cuenta.getSaldo(), cuenta2.getSaldo());
    }

    @Test
    @DisplayName("DevolverCuenta")
    void devolverCuenta(){
        assertEquals(123456789, cuenta.getAccountNumber(), "Debe devolver el número de la cuenta");
    }

    @Test
    @DisplayName("DevolverToString")
    void devolverToString(){
        assertEquals("123456789	Antonio	100.000,00 €", cuenta2.toString());
    }









}
