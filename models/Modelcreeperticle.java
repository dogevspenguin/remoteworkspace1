// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelcreeperticle extends ModelBase {
	private final ModelRenderer leg2;
	private final ModelRenderer leg;
	private final ModelRenderer body;
	private final ModelRenderer HEAD;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public Modelcreeperticle() {
		textureWidth = 64;
		textureHeight = 64;

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg2.cubeList.add(new ModelBox(leg2, 0, 32, 0.0F, -6.0F, -5.75F, 4, 6, 4, 0.0F, false));

		leg = new ModelRenderer(this);
		leg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg.cubeList.add(new ModelBox(leg, 32, 0, -4.0F, -6.0F, -5.75F, 4, 6, 4, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 16, -4.0F, -18.0F, -1.75F, 8, 12, 4, 0.0F, false));

		HEAD = new ModelRenderer(this);
		HEAD.setRotationPoint(0.0F, 24.0F, 0.0F);
		HEAD.cubeList.add(new ModelBox(HEAD, 0, 0, -4.0F, -26.0F, -3.5F, 8, 8, 8, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg3.cubeList.add(new ModelBox(leg3, 24, 24, 0.0F, -6.0F, 2.25F, 4, 6, 4, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(0.0F, 24.0F, 0.0F);
		leg4.cubeList.add(new ModelBox(leg4, 28, 12, -4.0F, -6.0F, 2.25F, 4, 6, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		leg2.render(f5);
		leg.render(f5);
		body.render(f5);
		HEAD.render(f5);
		leg3.render(f5);
		leg4.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}