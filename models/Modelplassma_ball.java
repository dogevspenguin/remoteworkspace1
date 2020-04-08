// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelplassma_ball extends EntityModel {
	private final RendererModel bb_main;

	public Modelplassma_ball() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new RendererModel(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}