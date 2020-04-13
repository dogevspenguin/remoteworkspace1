// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelcod extends ModelBase {
	private final ModelRenderer bb_main;

	public Modelcod() {
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, -2.0F, -4.0F, -6.0F, 4, 4, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 10, -1.0F, -4.0F, -2.0F, 2, 4, 6, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 3, 0.0F, -2.25F, 4.0F, 0, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 2, 1, 0.0F, -3.25F, 5.0F, 0, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 2, 0, 0.0F, -1.25F, 5.0F, 0, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 2, 2, 0.0F, -4.25F, 6.0F, 0, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 2, 0.0F, -0.25F, 6.0F, 0, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 1, 0.0F, -1.25F, 6.0F, 0, 1, 1, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 0, 0.0F, -3.25F, 6.0F, 0, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}