package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.container.ContainerWeaponUpgrade;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiWeaponUpgrade extends GuiContainer
{
    //TODO: Use GuiEnchantment as a gui to make something similar.

    private static final ResourceLocation guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "guiWeaponUpgrade.png");
    private static final ResourceLocation vanillaTempGuiImage = new ResourceLocation("textures/gui/container/enchanting_table.png");

    private ContainerWeaponUpgrade container;

    public GuiWeaponUpgrade(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        super(new ContainerWeaponUpgrade(invPlayer, world));
        container = (ContainerWeaponUpgrade) inventorySlots;
        this.xSize = 175;
        this.ySize = 203;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        //Draw gui
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiImage);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        //TODO: Adjust text position according to texture.
        //Draw text
        this.fontRendererObj.drawString(new TextComponentTranslation(MHBlocks.blockWeaponUpgrade.getUnlocalizedName() + ".name").getUnformattedText(), 8, 4, 4210752);
        this.fontRendererObj.drawString(new TextComponentTranslation("container.inventory").getUnformattedText(), 8, this.ySize - 92, 4210752);
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    /**
     * Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton
     */
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;

        for(int upgrade = 0; upgrade < 5; upgrade++)
        {
            int l = mouseX - (i + 60);
            int i1 = mouseY - (j + 14 + 19 * upgrade);

            if (l >= 0 && i1 >= 0 && l < 108 && i1 < 19 && container.enchantItem(this.mc.thePlayer, upgrade))
            {
                this.mc.playerController.sendEnchantPacket(container.windowId, upgrade);
            }
        }
    }
}
