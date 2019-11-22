package logic;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import logic.types.ColorType;

public class CellTest {
	private List<Cell> cells;

	@Before
	public void initTest() {
		cells = new ArrayList<Cell>();
		for (int i = 0; i <= 36; i++) {
			cells.add(new Cell(i));
		}
	}

	@Test
	public void createRulette() {
		assertEquals(cells.get(1).getColorType(), ColorType.RED);
		assertEquals(cells.get(2).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(3).getColorType(), ColorType.RED);
		assertEquals(cells.get(4).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(5).getColorType(), ColorType.RED);
		assertEquals(cells.get(6).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(7).getColorType(), ColorType.RED);
		assertEquals(cells.get(8).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(9).getColorType(), ColorType.RED);
		assertEquals(cells.get(10).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(11).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(12).getColorType(), ColorType.RED);
		assertEquals(cells.get(13).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(14).getColorType(), ColorType.RED);
		assertEquals(cells.get(15).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(16).getColorType(), ColorType.RED);
		assertEquals(cells.get(17).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(18).getColorType(), ColorType.RED);
		assertEquals(cells.get(19).getColorType(), ColorType.RED);
		assertEquals(cells.get(20).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(21).getColorType(), ColorType.RED);
		assertEquals(cells.get(22).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(23).getColorType(), ColorType.RED);
		assertEquals(cells.get(24).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(25).getColorType(), ColorType.RED);
		assertEquals(cells.get(26).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(27).getColorType(), ColorType.RED);
		assertEquals(cells.get(28).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(29).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(30).getColorType(), ColorType.RED);
		assertEquals(cells.get(31).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(32).getColorType(), ColorType.RED);
		assertEquals(cells.get(33).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(34).getColorType(), ColorType.RED);
		assertEquals(cells.get(35).getColorType(), ColorType.BLACK);
		assertEquals(cells.get(36).getColorType(), ColorType.RED);
	}

	@Test
	public void changeValue() {
		Cell cell = new Cell(27);
		assertEquals(cell.getColorType(), ColorType.RED);
		cell.setValue(28);
		assertEquals(cell.getColorType(), ColorType.BLACK);
		cell.setValue(29);
		assertEquals(cell.getColorType(), ColorType.BLACK);
	}

	@Test
	public void checkDozen() {
		assertEquals(cells.get(1).getDozen(), 0);
		assertEquals(cells.get(2).getDozen(), 0);
		assertEquals(cells.get(3).getDozen(), 0);
		assertEquals(cells.get(4).getDozen(), 0);
		assertEquals(cells.get(5).getDozen(), 0);
		assertEquals(cells.get(6).getDozen(), 0);
		assertEquals(cells.get(7).getDozen(), 0);
		assertEquals(cells.get(8).getDozen(), 0);
		assertEquals(cells.get(9).getDozen(), 0);
		assertEquals(cells.get(10).getDozen(), 0);
		assertEquals(cells.get(11).getDozen(), 0);
		assertEquals(cells.get(12).getDozen(), 1);
		assertEquals(cells.get(13).getDozen(), 1);
		assertEquals(cells.get(14).getDozen(), 1);
		assertEquals(cells.get(15).getDozen(), 1);
		assertEquals(cells.get(16).getDozen(), 1);
		assertEquals(cells.get(17).getDozen(), 1);
		assertEquals(cells.get(18).getDozen(), 1);
		assertEquals(cells.get(19).getDozen(), 1);
		assertEquals(cells.get(20).getDozen(), 1);
		assertEquals(cells.get(21).getDozen(), 1);
		assertEquals(cells.get(22).getDozen(), 1);
		assertEquals(cells.get(23).getDozen(), 1);
		assertEquals(cells.get(24).getDozen(), 2);
		assertEquals(cells.get(25).getDozen(), 2);
		assertEquals(cells.get(26).getDozen(), 2);
		assertEquals(cells.get(27).getDozen(), 2);
		assertEquals(cells.get(28).getDozen(), 2);
		assertEquals(cells.get(29).getDozen(), 2);
		assertEquals(cells.get(30).getDozen(), 2);
		assertEquals(cells.get(31).getDozen(), 2);
		assertEquals(cells.get(32).getDozen(), 2);
		assertEquals(cells.get(33).getDozen(), 2);
		assertEquals(cells.get(34).getDozen(), 2);
		assertEquals(cells.get(35).getDozen(), 2);
	}

	@Test
	public void checkFail() {
		assertEquals(cells.get(1).isFail(), false);
		assertEquals(cells.get(2).isFail(), false);
		assertEquals(cells.get(3).isFail(), false);
		assertEquals(cells.get(4).isFail(), false);
		assertEquals(cells.get(5).isFail(), false);
		assertEquals(cells.get(6).isFail(), false);
		assertEquals(cells.get(7).isFail(), false);
		assertEquals(cells.get(8).isFail(), false);
		assertEquals(cells.get(9).isFail(), false);
		assertEquals(cells.get(10).isFail(), false);
		assertEquals(cells.get(11).isFail(), false);
		assertEquals(cells.get(12).isFail(), false);
		assertEquals(cells.get(13).isFail(), false);
		assertEquals(cells.get(14).isFail(), false);
		assertEquals(cells.get(15).isFail(), false);
		assertEquals(cells.get(16).isFail(), false);
		assertEquals(cells.get(17).isFail(), false);
		assertEquals(cells.get(18).isFail(), true);
		assertEquals(cells.get(19).isFail(), true);
		assertEquals(cells.get(20).isFail(), true);
		assertEquals(cells.get(21).isFail(), true);
		assertEquals(cells.get(22).isFail(), true);
		assertEquals(cells.get(23).isFail(), true);
		assertEquals(cells.get(24).isFail(), true);
		assertEquals(cells.get(25).isFail(), true);
		assertEquals(cells.get(26).isFail(), true);
		assertEquals(cells.get(27).isFail(), true);
		assertEquals(cells.get(28).isFail(), true);
		assertEquals(cells.get(29).isFail(), true);
		assertEquals(cells.get(30).isFail(), true);
		assertEquals(cells.get(31).isFail(), true);
		assertEquals(cells.get(32).isFail(), true);
		assertEquals(cells.get(33).isFail(), true);
		assertEquals(cells.get(34).isFail(), true);
		assertEquals(cells.get(35).isFail(), true);
	}

	@Test
	public void checkColumn() {
		assertEquals(cells.get(1).getColumn(), 1);
		assertEquals(cells.get(2).getColumn(), 2);
		assertEquals(cells.get(3).getColumn(), 0);
		assertEquals(cells.get(4).getColumn(), 1);
		assertEquals(cells.get(5).getColumn(), 2);
		assertEquals(cells.get(6).getColumn(), 0);
		assertEquals(cells.get(7).getColumn(), 1);
		assertEquals(cells.get(8).getColumn(), 2);
		assertEquals(cells.get(9).getColumn(), 0);
		assertEquals(cells.get(10).getColumn(), 1);
		assertEquals(cells.get(11).getColumn(), 2);
		assertEquals(cells.get(12).getColumn(), 0);
		assertEquals(cells.get(13).getColumn(), 1);
		assertEquals(cells.get(14).getColumn(), 2);
		assertEquals(cells.get(15).getColumn(), 0);
		assertEquals(cells.get(16).getColumn(), 1);
		assertEquals(cells.get(17).getColumn(), 2);
		assertEquals(cells.get(18).getColumn(), 0);
		assertEquals(cells.get(19).getColumn(), 1);
		assertEquals(cells.get(20).getColumn(), 2);
		assertEquals(cells.get(21).getColumn(), 0);
		assertEquals(cells.get(22).getColumn(), 1);
		assertEquals(cells.get(23).getColumn(), 2);
		assertEquals(cells.get(24).getColumn(), 0);
		assertEquals(cells.get(25).getColumn(), 1);
		assertEquals(cells.get(26).getColumn(), 2);
		assertEquals(cells.get(27).getColumn(), 0);
		assertEquals(cells.get(28).getColumn(), 1);
		assertEquals(cells.get(29).getColumn(), 2);
		assertEquals(cells.get(30).getColumn(), 0);
		assertEquals(cells.get(31).getColumn(), 1);
		assertEquals(cells.get(32).getColumn(), 2);
		assertEquals(cells.get(33).getColumn(), 0);
		assertEquals(cells.get(34).getColumn(), 1);
		assertEquals(cells.get(35).getColumn(), 2);
	}

}
