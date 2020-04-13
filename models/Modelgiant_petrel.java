// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelgiant_petrel extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer wing;
	private final ModelRenderer secondary1;
	private final ModelRenderer secondary2;
	private final ModelRenderer thirdayry1;
	private final ModelRenderer thirdayry2;

	public Modelgiant_petrel() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 5, -0.5F, -4.75F, -12.25F, 1, 1, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 42, -2.5F, -6.0F, -8.0F, 5, 4, 5, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -2.75F, -6.75F, -5.0F, 5, 5, 12, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 28, 9, -2.0F, -6.0F, 7.0F, 4, 4, 8, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -1.0F, -5.0F, 15.0F, 2, 2, 3, 0.0F, false));

		wing = new ModelRenderer(this);
		wing.setRotationPoint(0.0F, 24.0F, 0.0F);
		wing.cubeList.add(new ModelBox(wing, 40, 40, 2.75F, -6.0F, -3.0F, 4, 2, 8, 0.0F, false));
		wing.cubeList.add(new ModelBox(wing, 24, 33, -6.75F, -6.0F, -3.0F, 4, 2, 8, 0.0F, false));

		secondary1 = new ModelRenderer(this);
		secondary1.setRotationPoint(3.0F, 0.0F, 0.0F);
		setRotationAngle(secondary1, 0.0F, -0.1745F, 0.0F);
		wing.addChild(secondary1);
		secondary1.cubeList.add(new ModelBox(secondary1, 21, 25, 3.0F, -5.0F, -3.0F, 7, 1, 7, 0.0F, false));

		secondary2 = new ModelRenderer(this);
		secondary2.setRotationPoint(-16.0F, 0.0F, 3.0F);
		setRotationAngle(secondary2, 0.0F, 0.2618F, 0.0F);
		wing.addChild(secondary2);
		secondary2.cubeList.add(new ModelBox(secondary2, 0, 24, 3.0F, -5.0F, -3.0F, 7, 1, 7, 0.0F, false));

		thirdayry1 = new ModelRenderer(this);
		thirdayry1.setRotationPoint(0.0F, -4.0F, -5.0F);
		setRotationAngle(thirdayry1, 0.0F, 0.3491F, 0.0F);
		wing.addChild(thirdayry1);
		thirdayry1.cubeList.add(new ModelBox(thirdayry1, 22, 0, -25.0F, -1.0F, 0.0F, 11, 1, 6, 0.0F, false));

		thirdayry2 = new ModelRenderer(this);
		thirdayry2.setRotationPoint(37.0F, -4.0F, 8.0F);
		setRotationAngle(thirdayry2, 0.0F, -0.3491F, 0.0F);
		wing.addChild(thirdayry2);
		thirdayry2.cubeList.add(new ModelBox(thirdayry2, 0, 17, -25.0F, -1.0F, 0.0F, 11, 1, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		wing.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}