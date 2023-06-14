package ru.netology.javaqa.homework.thirteen;

import com.sun.source.tree.Scope;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Comparator;

public class TicketTest {

    @Test
    public void TicketsCompareToEquals() {

        Ticket ticket1 = new Ticket(
                "Almaty",
                "Moscow",
                10_000,
                16_00,
                20_00
        );


        Ticket ticket2 = new Ticket(
                "Almaty",
                "Moscow",
                10_000,
                16_00,
                20_00
        );

        Assertions.assertEquals(0, ticket1.compareTo(ticket2));
    }

    @Test
    public void TicketsCompareToNotEquals() {

        Ticket ticket1 = new Ticket(
                "Almaty",
                "Moscow",
                10_000,
                16_00,
                20_00
        );


        Ticket ticket2 = new Ticket(
                "Almaty",
                "Moscow",
                20_000,
                16_00,
                20_00
        );

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
    }

    @Test
    public void TestSortTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Almaty", "Moscow", 10_000, 16, 20);
        Ticket ticket2 = new Ticket("Almaty", "St. Petersburg", 20_000, 15, 19);
        Ticket ticket3 = new Ticket("Moscow", "Krasnoyarsk", 17_000, 10, 15);
        Ticket ticket4 = new Ticket("Krasnoyarsk", "Moscow", 7_000, 7, 11);
        Ticket ticket5 = new Ticket("Krasnoyarsk", "Novosibirsk", 10_000, 10, 15);
        Ticket ticket6 = new Ticket("Tomsk", "Krasnoyarsk", 6_000, 12, 16);
        Ticket ticket7 = new Ticket("Krasnoyarsk", "Almaty", 9_000, 17, 22);
        Ticket ticket8 = new Ticket("Almaty", "Moscow", 8_000, 17, 22);
        Ticket ticket9 = new Ticket("Almaty", "Moscow", 9_000, 17, 22);
        Ticket ticket10 = new Ticket("Almaty", "Moscow", 6_000, 17, 22);
        Ticket ticket11 = new Ticket("Almaty", "Moscow", 11_000, 17, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Ticket[] expected = {ticket10, ticket8, ticket9, ticket1, ticket11};
        Ticket[] actual = manager.search("Almaty", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSortNotResults() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Almaty", "Moscow", 10_000, 16, 20);
        Ticket ticket2 = new Ticket("Almaty", "St. Petersburg", 20_000, 15, 19);
        Ticket ticket3 = new Ticket("Moscow", "Krasnoyarsk", 17_000, 10, 15);
        Ticket ticket4 = new Ticket("Krasnoyarsk", "Moscow", 7_000, 7, 11);
        Ticket ticket5 = new Ticket("Krasnoyarsk", "Novosibirsk", 10_000, 10, 15);
        Ticket ticket6 = new Ticket("Tomsk", "Krasnoyarsk", 6_000, 12, 16);
        Ticket ticket7 = new Ticket("Krasnoyarsk", "Almaty", 9_000, 17, 22);
        Ticket ticket8 = new Ticket("Almaty", "Moscow", 8_000, 17, 22);
        Ticket ticket9 = new Ticket("Almaty", "Moscow", 9_000, 17, 22);
        Ticket ticket10 = new Ticket("Almaty", "Moscow", 6_000, 17, 22);
        Ticket ticket11 = new Ticket("Almaty", "Moscow", 11_000, 17, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Almaty", "Tomsk");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void TestSortSearchOneResult() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Almaty", "Moscow", 10_000, 16, 20);
        Ticket ticket2 = new Ticket("Almaty", "St. Petersburg", 20_000, 15, 19);
        Ticket ticket3 = new Ticket("Moscow", "Krasnoyarsk", 17_000, 10, 15);
        Ticket ticket4 = new Ticket("Krasnoyarsk", "Moscow", 7_000, 7, 11);
        Ticket ticket5 = new Ticket("Krasnoyarsk", "Novosibirsk", 10_000, 10, 15);
        Ticket ticket6 = new Ticket("Tomsk", "Krasnoyarsk", 6_000, 12, 16);
        Ticket ticket7 = new Ticket("Krasnoyarsk", "Almaty", 9_000, 17, 22);
        Ticket ticket8 = new Ticket("Almaty", "Moscow", 8_000, 17, 22);
        Ticket ticket9 = new Ticket("Almaty", "Moscow", 9_000, 17, 22);
        Ticket ticket10 = new Ticket("Almaty", "Moscow", 6_000, 17, 22);
        Ticket ticket11 = new Ticket("Almaty", "Moscow", 11_000, 17, 22);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("Moscow", "Krasnoyarsk");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void TestSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Almaty", "Moscow", 10_000, 16, 19); //3
        Ticket ticket2 = new Ticket("Almaty", "St. Petersburg", 20_000, 15, 19); //3
        Ticket ticket3 = new Ticket("Moscow", "Krasnoyarsk", 17_000, 10, 15); //5
        Ticket ticket4 = new Ticket("Krasnoyarsk", "Moscow", 7_000, 7, 11); //4
        Ticket ticket5 = new Ticket("Krasnoyarsk", "Novosibirsk", 10_000, 10, 15); //5
        Ticket ticket6 = new Ticket("Tomsk", "Krasnoyarsk", 6_000, 12, 16); //4
        Ticket ticket7 = new Ticket("Krasnoyarsk", "Almaty", 9_000, 17, 22); //5
        Ticket ticket8 = new Ticket("Almaty", "Moscow", 8_000, 17, 22); //5
        Ticket ticket9 = new Ticket("Almaty", "Moscow", 9_000, 17, 21); //4
        Ticket ticket10 = new Ticket("Almaty", "Moscow", 6_000, 17, 19); //2
        Ticket ticket11 = new Ticket("Almaty", "Moscow", 11_000, 17, 23); //6

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket10, ticket1, ticket9, ticket8, ticket11};
        Ticket[] actual = manager.searchAndSortBy("Almaty", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSortTicketsWithComparatorNotResult() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Almaty", "Moscow", 10_000, 16, 19); //3
        Ticket ticket2 = new Ticket("Almaty", "St. Petersburg", 20_000, 15, 19); //3
        Ticket ticket3 = new Ticket("Moscow", "Krasnoyarsk", 17_000, 10, 15); //5
        Ticket ticket4 = new Ticket("Krasnoyarsk", "Moscow", 7_000, 7, 11); //4
        Ticket ticket5 = new Ticket("Krasnoyarsk", "Novosibirsk", 10_000, 10, 15); //5
        Ticket ticket6 = new Ticket("Tomsk", "Krasnoyarsk", 6_000, 12, 16); //4
        Ticket ticket7 = new Ticket("Krasnoyarsk", "Almaty", 9_000, 17, 22); //5
        Ticket ticket8 = new Ticket("Almaty", "Moscow", 8_000, 17, 22); //5
        Ticket ticket9 = new Ticket("Almaty", "Moscow", 9_000, 17, 21); //4
        Ticket ticket10 = new Ticket("Almaty", "Moscow", 6_000, 17, 19); //2
        Ticket ticket11 = new Ticket("Almaty", "Moscow", 11_000, 17, 23); //6

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Almaty", "Tomsk", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSortTicketsWithComparatorOneResult() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Almaty", "Moscow", 10_000, 16, 19); //3
        Ticket ticket2 = new Ticket("Almaty", "St. Petersburg", 20_000, 15, 19); //3
        Ticket ticket3 = new Ticket("Moscow", "Krasnoyarsk", 17_000, 10, 15); //5
        Ticket ticket4 = new Ticket("Krasnoyarsk", "Moscow", 7_000, 7, 11); //4
        Ticket ticket5 = new Ticket("Krasnoyarsk", "Novosibirsk", 10_000, 10, 15); //5
        Ticket ticket6 = new Ticket("Tomsk", "Krasnoyarsk", 6_000, 12, 16); //4
        Ticket ticket7 = new Ticket("Krasnoyarsk", "Almaty", 9_000, 17, 22); //5
        Ticket ticket8 = new Ticket("Almaty", "Moscow", 8_000, 17, 22); //5
        Ticket ticket9 = new Ticket("Almaty", "Moscow", 9_000, 17, 21); //4
        Ticket ticket10 = new Ticket("Almaty", "Moscow", 6_000, 17, 19); //2
        Ticket ticket11 = new Ticket("Almaty", "Moscow", 11_000, 17, 23); //6

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);

        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.searchAndSortBy("Krasnoyarsk", "Almaty", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

