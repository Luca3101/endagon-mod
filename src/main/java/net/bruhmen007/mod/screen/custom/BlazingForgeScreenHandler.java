package net.bruhmen007.mod.screen.custom;

import net.bruhmen007.mod.block.entity.custom.BlazingForgeBlockEntity;
import net.bruhmen007.mod.item.ModItems;
import net.bruhmen007.mod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BlazingForgeScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final BlazingForgeBlockEntity blockEntity;

    public BlazingForgeScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId,inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(4));
    }

    public BlazingForgeScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.BLAZING_FORGE_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);
        this.blockEntity = ((BlazingForgeBlockEntity) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new Slot(inventory, 0, 22, 21) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.NETHERITE_INGOT);
            }
        });


        this.addSlot(new Slot(inventory, 1, 52, 21) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(ModItems.VOID_CRYSTAL_DUST);
            }
        });


        this.addSlot(new Slot(inventory, 2, 37, 50) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.BLAZE_POWDER);
            }
        });


        this.addSlot(new Slot(inventory, 3, 113, 34) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int arrowPixelSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }


    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }


}
