package uk.gaz492.bambooeverything;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import uk.gaz492.bambooeverything.blocks.*;
import uk.gaz492.bambooeverything.util.ModInfo;

import java.util.function.Supplier;

public class BERegistry {

    //Bundle
    public static Block bambooBundleBlock;
    public static Item bambooBundleItem;

    //Slab
    public static Block bambooSlabBlock;
    public static Item bambooSlabItem;

    //Stairs
    public static Block bambooStairsBlock;
    public static Item bambooStairsItem;

    //Ladder
    public static Block bambooLadderBlock;
    public static Item bambooLadderItem;

    //Fence
    public static Block bambooFenceBlock;
    public static Item bambooFenceItem;
    public static Block bambooFenceGateBlock;
    public static Item bambooFenceGateItem;

    //(Trap)Door
    public static Block bambooDoorBlock;
    public static Item bambooDoorItem;
    public static Block bambooTrapDoorBlock;
    public static Item bambooTrapDoorItem;

    public static ItemGroup creativeTab = FabricItemGroupBuilder.build(new Identifier(ModInfo.ID + ":bambooeverything"), new Supplier<ItemStack>() {
        @Override
        public ItemStack get() {
            return new ItemStack(bambooFenceBlock);
        }
    });

    private final Item.Settings defaultSettings = new Item.Settings().group(creativeTab);

    BERegistry(BambooEverything mod){
    	
        //Bundle
        this.bambooBundleBlock = this.blockRegister("bamboo_bundle", new BambooBundleBlock(FabricBlockSettings.of(Material.BAMBOO).strength(1.0f, 2.0f).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooBundleItem = this.itemRegister("bamboo_bundle", this.bambooBundleBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooBundleItem, 300);
        
        //Slab
        this.bambooSlabBlock = this.blockRegister("bamboo_slab", new BambooSlabBlock(FabricBlockSettings.of(Material.BAMBOO).strength(1.0f, 2.0f).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooSlabItem = this.itemRegister("bamboo_slab", this.bambooSlabBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooSlabItem, 150);
        
        //Stairs
        this.bambooStairsBlock = this.blockRegister("bamboo_stairs", new BambooStairsBlock(bambooBundleBlock.getDefaultState(), FabricBlockSettings.of(Material.BAMBOO).strength(1.0f, 2.0f).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooStairsItem = this.itemRegister("bamboo_stairs", this.bambooStairsBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooStairsItem, 300);
        
        //Ladder
        this.bambooLadderBlock = this.blockRegister("bamboo_ladder", new BambooLadderBlock(FabricBlockSettings.of(Material.BAMBOO).strength(0.4F,0.4F).sounds(BlockSoundGroup.LADDER).nonOpaque()));
        this.bambooLadderItem = this.itemRegister("bamboo_ladder", this.bambooLadderBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooLadderItem, 300);
        
        //Fence
        this.bambooFenceBlock = this.blockRegister("bamboo_fence", new BambooFenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooFenceItem = this.itemRegister("bamboo_fence", this.bambooFenceBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooFenceItem, 300);
        
        this.bambooFenceGateBlock = this.blockRegister("bamboo_fence_gate", new BambooFenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooFenceGateItem = this.itemRegister("bamboo_fence_gate", this.bambooFenceGateBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooFenceGateItem, 300);
        
        //Door
        this.bambooDoorBlock = this.blockRegister("bamboo_door", new BambooDoorBlock(FabricBlockSettings.of(Material.BAMBOO).strength(3.0F, 3.0F).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooDoorItem = this.itemRegister("bamboo_door", this.bambooDoorBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooDoorItem, 200);
        
        this.bambooTrapDoorBlock = this.blockRegister("bamboo_trapdoor", new BambooTrapDoorBlock(FabricBlockSettings.of(Material.BAMBOO).strength(3.0F, 3.0F).sounds(BlockSoundGroup.BAMBOO)));
        this.bambooTrapDoorItem = this.itemRegister("bamboo_trapdoor", this.bambooTrapDoorBlock, this.defaultSettings);
        FuelRegistry.INSTANCE.add(bambooTrapDoorItem, 300);
    }

    private Block blockRegister(String id, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(ModInfo.ID, id), block);
    }

    private Item itemRegister (String id, Block block, Item.Settings settings){
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.ID, id), new BlockItem(block, settings));
    }
}
