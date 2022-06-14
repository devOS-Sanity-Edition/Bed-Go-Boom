package one.devos.nautical.fabrictemplatemod.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Creeper.class)
public abstract class CreeperMixin extends Entity {
	public CreeperMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	// Just an example Creeper mixin, drops skull on 1/10 chance

	/**
	 * @author IMS
	 */
	@Overwrite
	public boolean canDropMobsSkull() {
		return this.random.nextInt(10) == 1;
	}
}
