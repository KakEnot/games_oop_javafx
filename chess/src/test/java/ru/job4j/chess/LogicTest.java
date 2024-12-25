package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveAndPlaceIsOccupied() throws OccupiedCellException, FigureNotFoundException {

        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            BishopBlack bishopBlack = new BishopBlack(Cell.C1);
            KingBlack kingBlack = new KingBlack(Cell.D2);
            Logic logic = new Logic();
            logic.add(bishopBlack);
            logic.add(kingBlack);
            logic.move(Cell.C1, Cell.D2);
        });
        assertThat(exception.getMessage()).isEqualTo("Place is occupied by another figure");
    }
}