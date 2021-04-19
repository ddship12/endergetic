package com.minecraftabnormals.endergetic.common.entities.eetle.ai.brood;

import com.minecraftabnormals.abnormals_core.core.endimator.entity.EndimatedGoal;
import com.minecraftabnormals.endergetic.api.entity.util.DetectionHelper;
import com.minecraftabnormals.endergetic.common.entities.eetle.AbstractEetleEntity;
import com.minecraftabnormals.endergetic.common.entities.eetle.BroodEetleEntity;
import com.minecraftabnormals.endergetic.common.entities.eetle.BroodEggSackEntity;
import com.minecraftabnormals.endergetic.common.entities.eetle.EetleEggsEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class BroodEetleDropEggsGoal extends EndimatedGoal<BroodEetleEntity> {
	private int eggsToDrop;
	private int ticksPassed;

	public BroodEetleDropEggsGoal(BroodEetleEntity entity) {
		super(entity, BroodEetleEntity.LAUNCH);
	}

	@Override
	public boolean shouldExecute() {
		BroodEetleEntity broodEetle = this.entity;
		return broodEetle.getTicksFlying() >= 100 && broodEetle.canDropOffEggs() && broodEetle.isFlying() && !broodEetle.isOnGround() && broodEetle.isNoEndimationPlaying() && notNearGround(broodEetle) && areFewEetlesNearby(broodEetle) && !BroodEetleFlingGoal.searchForNearbyAggressors(broodEetle, broodEetle.getAttributeValue(Attributes.FOLLOW_RANGE)).isEmpty() && this.random.nextFloat() < 0.025F;
	}

	@Override
	public void startExecuting() {
		BroodEetleEntity broodEetle = this.entity;
		broodEetle.setDroppingEggs(true);
		broodEetle.resetEggDropOffCooldown();
		this.eggsToDrop = this.random.nextInt(3) + 4;
	}

	@Override
	public void tick() {
		this.ticksPassed++;

		BroodEetleEntity broodEetle = this.entity;
		if (broodEetle.isEggMouthOpen() && this.ticksPassed % 20 == 0) {
			this.playEndimation();
			World world = broodEetle.world;
			BroodEggSackEntity eggSack = broodEetle.getEggSack(world);
			if (eggSack != null) {
				EetleEggsEntity eetleEgg = new EetleEggsEntity(world, eggSack.getPositionVec());
				Random random = this.random;
				eetleEgg.setEggSize(EetleEggsEntity.EggSize.random(random));
				eetleEgg.setMotion(new Vector3d((random.nextFloat() - random.nextFloat()) * 0.3F, -0.1F, (random.nextFloat() - random.nextFloat()) * 0.3F).add(broodEetle.getMotion()));
				world.addEntity(eetleEgg);
				this.eggsToDrop--;
			}
		}
	}

	@Override
	public boolean shouldContinueExecuting() {
		return this.entity.isFlying() && this.eggsToDrop > 0;
	}

	@Override
	public void resetTask() {
		this.entity.setDroppingEggs(false);
	}

	private static boolean areFewEetlesNearby(BroodEetleEntity broodEetle) {
		return broodEetle.world.getEntitiesWithinAABB(AbstractEetleEntity.class, broodEetle.getBoundingBox().grow(broodEetle.getAttributeValue(Attributes.FOLLOW_RANGE)), eetle -> {
			return eetle.isAlive() && (!eetle.isChild() || eetle.getGrowingAge() >= -240);
		}).size() <= 2;
	}

	private static boolean notNearGround(BroodEetleEntity broodEetle) {
		return broodEetle.world.hasNoCollisions(DetectionHelper.checkOnGround(broodEetle.getBoundingBox(), -4.0F));
	}
}