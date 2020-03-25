// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelbabypenguin extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer left_flap;
	private final ModelRenderer right_flap;
	private final ModelRenderer head;
	private final ModelRenderer head1;

	public Modelbabypenguin() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 15, 19, -2.75F, -2.0F, -2.5F, 5,
				1, 5, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -11.0F, -3.0F, 6, 9,
				6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 3, -2.0F, -1.0F, -1.0F, 1, 1,
				2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, 1.0F, -1.0F, -1.0F, 1, 1, 2,
				0.0F, false));

		left_flap = new ModelRenderer(this);
		left_flap.setRotationPoint(0.0F, 24.0F, 0.0F);
		left_flap.cubeList.add(new ModelBox(left_flap, 0, 24, -3.5F, -10.0F,
				-1.0F, 1, 7, 2, 0.0F, false));

		right_flap = new ModelRenderer(this);
		right_flap.setRotationPoint(0.0F, 24.0F, 0.0F);
		right_flap.cubeList.add(new ModelBox(right_flap, 6, 24, 2.5F, -10.0F,
				-1.0F, 1, 7, 2, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 15, -2.5F, -15.0F, -3.25F, 5,
				4, 5, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 15, 15, -0.5F, -13.0F, -5.0F, 1,
				1, 2, 0.0F, false));

		head1 = new ModelRenderer(this);
		head1.setRotationPoint(0.0F, 0.4545F, 0.5417F);
		setRotationAngle(head1, 0.0873F, 0.0F, 0.0F);
		head.addChild(head1);
		head1.cubeList.add(new ModelBox(head1, 18, 0, -2.75F, -12.0F, -2.75F,
				5, 1, 5, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		left_flap.render(f5);
		right_flap.render(f5);
		head.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}