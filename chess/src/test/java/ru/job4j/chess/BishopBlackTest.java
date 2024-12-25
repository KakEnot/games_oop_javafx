package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    public void checkPositionTest() {

        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(bishopBlack.position(), Cell.C1);
    }

    @Test
    public void checkCopyTest() {

        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertEquals(bishopBlack.copy(Cell.E3).position(), Cell.E3);
    }

    @Test
    public void checkAvailableWayTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.G5);
        Cell[] expect = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertEquals(steps, expect);
    }

    @Test
    public void whenUnavailableWayTest() throws ImpossibleMoveException {

        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            BishopBlack bishopBlack = new BishopBlack(Cell.C1);
            bishopBlack.way(Cell.C4);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to C4");
    }
}
