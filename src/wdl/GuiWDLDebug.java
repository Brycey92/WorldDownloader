package wdl;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GuiWDLDebug extends GuiScreen {
	private GuiScreen parent;
	
	public GuiWDLDebug(GuiScreen parent) {
		this.parent = parent;
	}
	
	@Override
	public void initGui() {
		int x = (this.width / 2) - 100;
		int y = (this.height / 4) - 15;
		
		this.buttonList.add(new GuiButton(100, x, y, "Master debug switch: " + 
				(WDLDebugMessageCause.globalDebugEnabled ? "On" : "Off")));
		
		WDLDebugMessageCause[] causes = WDLDebugMessageCause.values();
		
		y += 28;
		
		for (int i = 0; i < causes.length; i++) {
			this.buttonList.add(new GuiButton(i, x, y, causes[i].toString()));
			
			y += 22;
		}
		
		y += 6;
		
		this.buttonList.add(new GuiButton(101, x, y, "Done"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (!button.enabled) {
			return;
		}
		
		if (button.id == 100) {
			//"Master switch"
			WDLDebugMessageCause.globalDebugEnabled ^= true;
			
			for (Object obj : buttonList) {
				GuiButton btn = (GuiButton)obj;
				if (btn.id < 100) {
					btn.enabled = WDLDebugMessageCause.globalDebugEnabled;
				}
			}
		} else if (button.id == 101) {
			//TODO: Save settings.  (If needed)
			this.mc.displayGuiScreen(this.parent);
		} else {
			WDLDebugMessageCause cause = 
					WDLDebugMessageCause.values()[button.id];
			
			cause.toggleEnabled();
			
			button.displayString = cause.toString();
		}
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, "Debug options",
				this.width / 2, this.height / 4 - 40, 0xFFFFFF);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
