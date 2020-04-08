//Made with Blockbench
//Paste this code into your mod.

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer foot;
	private final ModelRenderer body;

	public Modelcustom_model() {
		textureWidth = 128;
		textureHeight = 128;

		foot = new ModelRenderer(this);
		foot.setRotationPoint(0.0F, 24.0F, 0.0F);
		foot.cubeList.add(new ModelBox(foot, 55, 0, 5.0F, -1.0F, -1.0F, 3, 1, 6, 0.0F, false));
		foot.cubeList.add(new ModelBox(foot, 49, 38, -8.0F, -1.0F, -1.0F, 3, 1, 6, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 35, -9.0F, -4.0F, -6.0F, 18, 3, 13, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 18, -10.0F, -6.0F, -7.0F, 20, 3, 14, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -10.0F, -9.0F, -8.0F, 20, 3, 15, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 55, 22, -8.0F, -11.0F, -7.0F, 16, 3, 13, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 52, -8.0F, -13.0F, -7.0F, 16, 3, 13, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 49, 49, -8.0F, -15.0F, -7.0F, 16, 3, 13, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 55, 7, -7.0F, -19.0F, -3.0F, 4, 4, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 45, 51, 3.0F, -19.0F, -3.0F, 4, 4, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		foot.render(f5);
		body.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}