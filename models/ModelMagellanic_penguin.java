// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelMagellanic_penguin extends EntityModel {
	private final RendererModel bb_main;

	public ModelMagellanic_penguin() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new RendererModel(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -3.5F, -13.0F, -3.0F, 6, 11, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 17, -3.0F, -17.0F, -2.75F, 5, 4, 4, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 23, 0, -1.0F, -15.0F, -3.25F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 0, -1.0F, -14.5F, -5.5F, 1, 1, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 4, -1.25F, -14.5F, -3.25F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 4, -0.75F, -14.5F, -3.25F, 1, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 24, -4.25F, -12.0F, -1.0F, 1, 6, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 18, 18, 2.25F, -12.0F, -1.0F, 1, 6, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 15, -4.25F, -6.0F, -0.75F, 1, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 2.25F, -6.0F, -0.75F, 1, 2, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 14, 17, -3.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 17, 1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 4, 1.0F, 0.0F, -2.0F, 1, 0, 2, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 2, 0, -3.0F, 0.0F, -2.0F, 1, 0, 2, 0.0F, false));
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