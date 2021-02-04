package appeng.integration.modules.jei;

import appeng.api.storage.data.IAEFluidStack;
import appeng.client.me.SlotFluidME;
import appeng.fluids.client.gui.GuiFluidTerminal;
import mezz.jei.api.gui.IAdvancedGuiHandler;
import net.minecraft.inventory.Slot;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class FluidTerminalGuiHandler implements IAdvancedGuiHandler<GuiFluidTerminal> {
    @Override
    public Class<GuiFluidTerminal> getGuiContainerClass() {
        return GuiFluidTerminal.class;
    }

    @Nullable
    @Override
    public List<Rectangle> getGuiExtraAreas(GuiFluidTerminal guiContainer) {
        return null;
    }

    @Nullable
    @Override
    public Object getIngredientUnderMouse(GuiFluidTerminal guiContainer, int mouseX, int mouseY) {
        Slot slot = guiContainer.getSlotUnderMouse();
        if (slot instanceof SlotFluidME) {
            SlotFluidME fluidSlot = (SlotFluidME) slot;
            IAEFluidStack aeFluidStack = fluidSlot.getAEFluidStack();
            if (aeFluidStack != null)
                return fluidSlot.getAEFluidStack().getFluidStack().copy();
        }
        return null;
    }
}
