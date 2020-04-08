// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelarticdog extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer regl1;
	private final ModelRenderer legr1;
	private final ModelRenderer legl2;
	private final ModelRenderer legr2;
	private final ModelRenderer head;
	private final ModelRenderer earright;
	private final ModelRenderer earleft;

	public Modelarticdog() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 28, 0, -1.0F, -9.0F, 5.0F, 2, 2, 6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -4.0F, -12.0F, -6.0F, 8, 7, 12, 0.0F, false));

		regl1 = new ModelRenderer(this);
		regl1.setRotationPoint(0.0F, 24.0F, -1.0F);
		regl1.cubeList.add(new ModelBox(regl1, 16, 31, -3.5F, -5.0F, -4.0F, 2, 5, 2, 0.0F, false));

		legr1 = new ModelRenderer(this);
		legr1.setRotationPoint(0.0F, 24.0F, 0.0F);
		legr1.cubeList.add(new ModelBox(legr1, 0, 0, 1.5F, -5.0F, -5.0F, 2, 5, 2, 0.0F, false));

		legl2 = new ModelRenderer(this);
		legl2.setRotationPoint(0.0F, 24.0F, 0.0F);
		legl2.cubeList.add(new ModelBox(legl2, 8, 31, -3.5F, -5.0F, 3.0F, 2, 5, 2, 0.0F, false));

		legr2 = new ModelRenderer(this);
		legr2.setRotationPoint(0.0F, 24.0F, 8.0F);
		legr2.cubeList.add(new ModelBox(legr2, 0, 31, 1.5F, -5.0F, -5.0F, 2, 5, 2, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 19, -3.0F, -11.5F, -12.0F, 6, 6, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 24, 24, -4.5F, -12.5F, -9.0F, 9, 8, 3, 0.0F, false));

		earright = new ModelRenderer(this);
		earright.setRotationPoint(0.0F, 0.25F, 0.0F);
		setRotationAngle(earright, 0.0F, 0.0F, 0.1745F);
		head.addChild(earright);
		earright.cubeList.add(new ModelBox(earright, 0, 7, -1.0F, -13.5F, -11.0F, 2, 2, 1, 0.0F, false));

		earleft = new ModelRenderer(this);
		earleft.setRotationPoint(2.0F, 0.0F, 1.0F);
		setRotationAngle(earleft, 0.0F, 0.0F, -0.1745F);
		head.addChild(earleft);
		earleft.cubeList.add(new ModelBox(earleft, 6, 7, -3.0F, -13.5F, -12.0F, 2, 2, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		regl1.render(f5);
		legr1.render(f5);
		legl2.render(f5);
		legr2.render(f5);
		head.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}