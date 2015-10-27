package ua.coral.corners.engine;

import ua.coral.corners.pojo.Cell;
import ua.coral.corners.pojo.ChipType;
import ua.coral.corners.pojo.Desc;

public class Engine {

    private final Desc desc;

    public Engine(final Desc desc) {
        this.desc = desc;
    }

    public void step(final int hIndex, final int vIndex) {
        final Cell cell = desc.getCell(hIndex, vIndex);
        switch (cell.getChip().getChipType()) {
            case BLACK:
                stepForBlack(hIndex, vIndex);
                break;
            case WHITE:
                stepForWhite(hIndex, vIndex);
                break;
        }
    }

    private void stepForBlack(final int hIndex, final int vIndex) {
        if (!canNextStep(hIndex, vIndex)) {
            return;
        }

    }

    private void stepForWhite(final int hIndex, final int vIndex) {
        if (!canNextStep(hIndex, vIndex)) {
            return;
        }
    }

    private boolean canNextStep(final int hIndex, final int vIndex) {
        boolean bResult = false;
        bResult |= isNotCellEmpty(hIndex + 1, vIndex);
        bResult |= isNotCellEmpty(hIndex + 2, vIndex);
        bResult |= isNotCellEmpty(hIndex, vIndex + 1);
        bResult |= isNotCellEmpty(hIndex, vIndex + 2);
        bResult |= isNotCellEmpty(hIndex - 1, vIndex);
        bResult |= isNotCellEmpty(hIndex - 2, vIndex);
        bResult |= isNotCellEmpty(hIndex, vIndex - 1);
        bResult |= isNotCellEmpty(hIndex, vIndex - 2);
        return bResult;
    }

    private boolean isNotCellEmpty(final int hIndex, final int vIndex) {
        return desc.getCell(hIndex, vIndex) != null
                && desc.getCell(hIndex, vIndex).getChip().getChipType() == ChipType.EMPTY;
    }
}
