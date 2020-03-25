// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class Modelempororpenguin extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer head2;
	private final ModelRenderer flapleft;
	private final ModelRenderer flapright;

	public Modelempororpenguin() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 22, 12, -3.35F, -2.0F, -3.25F, 6,
				1, 6, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, -3.75F, -13.0F, -3.75F, 7,
				11, 7, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 23, 20, 2.0F, -1.0F, -2.0F, 1, 1,
				3, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 18, 19, -3.0F, -1.0F, -2.0F, 1, 1,
				3, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 1.0F);
		head.cubeList.add(new ModelBox(head, 0, 18, -3.0F, -18.0F, -5.0F, 6, 5,
				6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 28, 7, -0.5F, -15.0F, -8.0F, 1, 1,
				3, 0.0F, false));

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, 0.5F, 0.0F);
		setRotationAngle(head2, 0.0873F, 0.0F, 0.0F);
		head.addChild(head2);
		head2.cubeList.add(new ModelBox(head2, 21, 0, -3.5F, -14.0F, -3.0F, 7,
				1, 6, 0.0F, false));

		flapleft = new ModelRenderer(this);
		flapleft.setRotationPoint(0.0F, 24.0F, 0.0F);
		flapleft.cubeList.add(new ModelBox(flapleft, 0, 29, 3.0F, -12.0F,
				-2.0F, 1, 9, 3, 0.0F, false));

		flapright = new ModelRenderer(this);
		flapright.setRotationPoint(0.0F, 24.0F, 0.0F);
		flapright.cubeList.add(new ModelBox(flapright, 24, 24, -4.0F, -12.0F,
				-2.0F, 1, 9, 3, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		body.render(f5);
		head.render(f5);
		flapleft.render(f5);
		flapright.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}