package endergeticexpansion.client.model.booflo;

import endergeticexpansion.api.endimator.EndimatorEntityModel;
import endergeticexpansion.api.endimator.EndimatorRendererModel;
import endergeticexpansion.common.entities.booflo.EntityBooflo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * BoofloDefault - Endergized
 * Created using Tabula 7.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelBooflo<E extends EntityBooflo> extends EndimatorEntityModel<E> {
    public EndimatorRendererModel Head;
    public EndimatorRendererModel Jaw;
    public EndimatorRendererModel KneeLeft;
    public EndimatorRendererModel KneeRight;
    public EndimatorRendererModel LegLeft;
    public EndimatorRendererModel LegRight;
    public EndimatorRendererModel LegBackLeft;
    public EndimatorRendererModel LegBackRight;
    public EndimatorRendererModel FruitPos;
    
    public ModelBooflo() {
        this.textureWidth = 100;
        this.textureHeight = 150;
        this.Jaw = new EndimatorRendererModel(this, 0, 0);
        this.Jaw.setRotationPoint(0.0F, 4.0F, 8.0F);
        this.Jaw.addBox(-8.0F, 0.0F, -16.0F, 16, 6, 16, 0.0F);
        this.LegLeft = new EndimatorRendererModel(this, 28, 59);
        this.LegLeft.setRotationPoint(8.5F, 2.0F, -3.0F);
        this.LegLeft.addBox(0.0F, -1.5F, -1.5F, 20, 3, 3, 0.0F);
        this.setRotateAngle(LegLeft, 0.0F, 0.5235987755982988F, 1.0471975511965976F);
        this.LegRight = new EndimatorRendererModel(this, 28, 59);
        this.LegRight.setRotationPoint(-8.5F, 2.0F, -3.0F);
        this.LegRight.addBox(0.0F, -1.5F, -1.5F, 20, 3, 3, 0.0F);
        this.setRotateAngle(LegRight, 0.0F, 0.5235987755982988F, 2.0943951023931953F);
        this.KneeRight = new EndimatorRendererModel(this, 0, 58);
        this.KneeRight.setRotationPoint(-5.5F, -2.0F, 5.5F);
        this.KneeRight.addBox(-2.5F, -10.0F, -2.5F, 5, 10, 5, 0.0F);
        this.setRotateAngle(KneeRight, 0.0F, 0.17453292519943295F, -0.7853981633974483F);
        this.KneeLeft = new EndimatorRendererModel(this, 0, 58);
        this.KneeLeft.setRotationPoint(5.5F, -2.0F, 5.5F);
        this.KneeLeft.addBox(-2.5F, -10.0F, -2.5F, 5, 10, 5, 0.0F);
        this.setRotateAngle(KneeLeft, 0.0F, -0.17453292519943295F, 0.7853981633974483F);
        this.LegBackRight = new EndimatorRendererModel(this, 0, 89);
        this.LegBackRight.setRotationPoint(-1.5F, -7.5F, 0.0F);
        this.LegBackRight.addBox(-25.0F, -1.5F, -1.5F, 25, 3, 3, 0.0F);
        this.setRotateAngle(LegBackRight, 0.0F, 0.3490658503988659F, -0.3490658503988659F);
        this.LegBackLeft = new EndimatorRendererModel(this, 0, 81);
        this.LegBackLeft.setRotationPoint(1.5F, -7.5F, -0.5F);
        this.LegBackLeft.addBox(0.0F, -1.5F, -1.5F, 25, 3, 3, 0.0F);
        this.setRotateAngle(LegBackLeft, 0.0F, -0.3490658503988659F, 0.3490658503988659F);
        this.Head = new EndimatorRendererModel(this, 0, 29);
        this.Head.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.Head.addBox(-9.0F, -4.0F, -9.0F, 18, 8, 18, 0.0F);
        this.setRotateAngle(Head, -0.091106186954104F, 0.0F, 0.0F);
        this.FruitPos = new EndimatorRendererModel(this, 0, 0);
        this.FruitPos.setRotationPoint(20.0F, -4.15F, -0.5F);
        this.FruitPos.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotateAngle(FruitPos, -0.7853981633974483F, -0.2617993877991494F, -1.3089969389957472F);
        this.Head.addChild(this.Jaw);
        this.Head.addChild(this.LegLeft);
        this.Head.addChild(this.LegRight);
        this.Head.addChild(this.KneeRight);
        this.Head.addChild(this.KneeLeft);
        this.KneeRight.addChild(this.LegBackRight);
        this.KneeLeft.addChild(this.LegBackLeft);
        this.LegRight.addChild(this.FruitPos);
        
        this.setDefaultBoxValues();
    }

    @Override
    public void render(E booflo, float f, float f1, float f2, float f3, float f4, float f5) {
    	this.animateModel(booflo, f, f1, f2, f3, f4, f5);
        this.Head.render(f5);
    }
    
    @Override
    public void setRotationAngles(E entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
    	this.revertBoxesToDefaultValues();
    }
    
    @Override
    public void animateModel(E booflo, float f, float f1, float f2, float f3, float f4, float f5) {
    	super.animateModel(booflo, f, f1, f2, f3, f4, f5);
    	this.endimator.updateAnimations(booflo);
    	
    	if(booflo.isEndimationPlaying(EntityBooflo.CROAK)) {
    		this.endimator.setAnimationToPlay(EntityBooflo.CROAK);
    		
    		this.endimator.startKeyframe(5);
    		this.endimator.rotate(this.Jaw, 0.25F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.setStaticKeyframe(45);
    		
    		this.endimator.startKeyframe(5);
    		this.endimator.rotate(this.Jaw, -0.0F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    	} else if(booflo.isEndimationPlaying(EntityBooflo.HOP)) {
    		this.endimator.setAnimationToPlay(EntityBooflo.HOP);
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.KneeRight, 0.0F, -0.6F, -0.2F);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.5F);
    		
    		this.endimator.rotate(this.KneeLeft, 0.0F, 0.6F, 0.2F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, -0.5F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, -0.75F, 0.14F);
    		this.endimator.rotate(this.LegLeft, 0.0F, -0.75F, -0.14F);
    		
    		this.endimator.rotate(this.Jaw, -0.02F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.Head, 0.05F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(5);
    		this.endimator.rotate(this.KneeRight, -0.18F, 0.33F, -0.2F);
    		this.endimator.rotate(this.LegBackRight, 0.06F, 0.33F, 0.18F);
    		
    		this.endimator.rotate(this.KneeLeft, -0.18F, -0.33F, 0.2F);
    		this.endimator.rotate(this.LegBackLeft, 0.06F, -0.33F, -0.18F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.47F, 0.0F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.47F, 0.0F);
    		
    		this.endimator.rotate(this.Jaw, 0.2F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.Head, -0.4F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    		
    		/*
    		 * Brings to Default
    		 */
    		this.endimator.startKeyframe(10);
    		this.endimator.endKeyframe();
    	} else if(booflo.isEndimationPlaying(EntityBooflo.HURT)) {
    		this.endimator.setAnimationToPlay(EntityBooflo.HURT);
    		
    		this.endimator.startKeyframe(5);
    		this.endimator.rotate(this.Jaw, 0.25F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.KneeRight, -0.18F, 0.23F, -0.2F);
    		this.endimator.rotate(this.LegBackRight, 0.06F, 0.23F, 0.18F);
    		
    		this.endimator.rotate(this.KneeLeft, -0.18F, -0.23F, 0.2F);
    		this.endimator.rotate(this.LegBackLeft, 0.06F, -0.23F, -0.18F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.30F, 0.0F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.30F, 0.0F);
    		
    		this.endimator.rotate(this.Head, 0.05F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.setStaticKeyframe(5);
    		
    		/*
    		 * Brings to Default
    		 */
    		this.endimator.startKeyframe(5);
    		this.endimator.endKeyframe();
    	} else if(booflo.isEndimationPlaying(EntityBooflo.BIRTH)) {
    		this.endimator.setAnimationToPlay(EntityBooflo.BIRTH);
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Head, 0.05F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.setStaticKeyframe(120);
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Head, 0.00F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    	} else if(booflo.isEndimationPlaying(EntityBooflo.EAT)) {
    		this.endimator.setAnimationToPlay(EntityBooflo.EAT);
    		
    		/*
    		 * Start
    		 */
    		this.endimator.startKeyframe(20);
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.4F, 0.0F, 0.0F);
    		this.endimator.rotate(this.Head, -0.1F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.03F, 0.05F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, -0.03F, -0.05F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.25F, -0.93F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.25F, 0.93F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.0F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.4F, 0.0F, 0.0F);
    		this.endimator.rotate(this.Head, -0.1F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.03F, 0.05F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, -0.03F, -0.05F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.25F, -0.93F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.25F, 0.93F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.0F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.4F, 0.0F, 0.0F);
    		this.endimator.rotate(this.Head, -0.1F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.03F, 0.05F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, -0.03F, -0.05F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.25F, -0.93F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.25F, 0.93F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.0F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.4F, 0.0F, 0.0F);
    		this.endimator.rotate(this.Head, -0.1F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.03F, 0.05F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, -0.03F, -0.05F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.25F, -0.93F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.25F, 0.93F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.0F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.4F, 0.0F, 0.0F);
    		this.endimator.rotate(this.Head, -0.1F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.03F, 0.05F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, -0.03F, -0.05F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.25F, -0.93F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.25F, 0.93F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.0F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.4F, 0.0F, 0.0F);
    		this.endimator.rotate(this.Head, -0.1F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.03F, 0.05F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, -0.03F, -0.05F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.25F, -0.93F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.25F, 0.93F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.LegBackRight, 0.0F, 0.0F, 0.0F);
    		this.endimator.rotate(this.LegBackLeft, 0.0F, 0.0F, 0.0F);
    		
    		this.endimator.rotate(this.LegRight, 0.0F, 0.15F, -0.9F);
    		this.endimator.rotate(this.LegLeft, 0.0F, 0.15F, 0.9F);
    		this.endimator.endKeyframe();
    		
    		//-------------------------------------------------------
    		
    		/*
    		 * End
    		 */
    		this.endimator.resetKeyframe(20);
    	} else if(booflo.isEndimationPlaying(EntityBooflo.GROWL)) {
    		this.endimator.setAnimationToPlay(EntityBooflo.GROWL);
    		
    		this.endimator.startKeyframe(10);
    		this.endimator.rotate(this.Jaw, 0.25F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    		
    		this.endimator.setStaticKeyframe(45);
    		
    		this.endimator.startKeyframe(5);
    		this.endimator.rotate(this.Jaw, -0.0F, 0.0F, 0.0F);
    		this.endimator.endKeyframe();
    	}
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(EndimatorRendererModel EndimatorRendererModel, float x, float y, float z) {
        EndimatorRendererModel.rotateAngleX = x;
        EndimatorRendererModel.rotateAngleY = y;
        EndimatorRendererModel.rotateAngleZ = z;
    }
}