// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelbackpack extends EntityModel {
	private final RendererModel backpack;

	public Modelbackpack() {
		textureWidth = 32;
		textureHeight = 32;

		backpack = new RendererModel(this);
		backpack.setRotationPoint(0.0F, 24.0F, 0.0F);
		backpack.cubeList.add(new ModelBox(backpack, 16, 11, 3.75F, -20.0F, -2.0F, 1, 1, 4, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 14, 6, -4.75F, -20.0F, -2.0F, 1, 1, 4, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 8, 10, 3.75F, -24.0F, -3.0F, 1, 5, 1, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 0, 10, -4.75F, -24.0F, -3.0F, 1, 5, 1, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 8, 11, 3.75F, -25.0F, -3.0F, 1, 1, 6, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 0, 10, -4.75F, -25.0F, -3.0F, 1, 1, 6, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 0, 0, -3.0F, -23.0F, 2.0F, 6, 7, 3, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 4, 17, 3.75F, -25.0F, 2.0F, 1, 6, 1, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 0, 17, -4.75F, -25.0F, 2.0F, 1, 6, 1, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 16, 13, 2.75F, -20.0F, 2.0F, 1, 1, 1, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 16, 11, -3.75F, -20.0F, 2.0F, 1, 1, 1, 0.0F, false));
		backpack.cubeList.add(new ModelBox(backpack, 15, 0, -0.5F, -21.0F, 5.0F, 1, 2, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		backpack.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}