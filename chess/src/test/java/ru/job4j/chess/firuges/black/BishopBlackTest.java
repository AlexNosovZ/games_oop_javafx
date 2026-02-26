package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void position() {
        Cell cell = Cell.findBy(1, 1);
        Figure bishopBlack = new BishopBlack(cell);
        assertThat(bishopBlack.position()).isEqualTo(cell);
    }

    @Test
    void copy() {
        Cell from = Cell.findBy(1, 1);
        Cell to = Cell.findBy(2, 2);
        Figure bishopBlack = new BishopBlack(from);
        bishopBlack = bishopBlack.copy(to);
        assertThat(bishopBlack.position()).isEqualTo(to);
    }

    @Test
    void way() {
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] output = bishopBlack.way(Cell.G5);
        assertThat(output).containsExactly(expected);
    }

    @Test
    void notDiagonalWay() {
        Figure bishopBlack = new BishopBlack(Cell.C8);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.D3)
        );
        String expected = "Could not move by diagonal from C8 to D3";
        assertThat(exception.getMessage()).isEqualTo(expected);
    }
}