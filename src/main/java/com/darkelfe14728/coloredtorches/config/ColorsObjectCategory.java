package com.darkelfe14728.coloredtorches.config;

import com.darkelfe14728.coloredtorches.log.LogHelper;
import com.darkelfe14728.coloredtorches.utils.Range;

import net.minecraft.item.ItemStack;

/**
 * Category : /colors/color_XXX
 * 
 * @author Julien Rosset
 */
public class ColorsObjectCategory 
	implements ICategory 
{	
	protected String id = null;
	protected int metadata = -1;
	
	protected Range craftRange = null;
	protected ItemStack craftingItem = null;

	public ColorsObjectCategory(String id, int metadata)
	{
		this.id = id;
		this.metadata = metadata;
	}
	public ColorsObjectCategory(String id, int metadata, ItemStack craftingItem)
	{
		this(id, metadata);
		this.craftingItem = craftingItem;
	}
	
	@Override
	public String getName()
	{
		return this.id;
	}

	public String getId()
	{
		return this.id;
	}
	public int getMetadata()
	{
		return this.metadata;
	}
	public Range getCraftBy()
	{
		return this.craftRange;
	}
	public ItemStack getCraftingItem()
	{
		return this.craftingItem;
	}
	
	@Override
	public void load(ImprovedConfiguration config)
	{
		LogHelper.info("craftRange");
		if(config.hasKey(config.currentCategory, "craftRange"))
			this.craftRange = config.getRange("craftRange", config.currentCategory, ModConfig.instance.crafting.craftRange, 1, 64, "Number of colored torches craft with on 'crafting item'");
		else
		{
			this.craftRange = ModConfig.instance.crafting.craftRange;
		}
		
		LogHelper.info("craftingItem");
		this.craftingItem = config.getItem("craftingItem", config.currentCategory, this.craftingItem, "Item used to craft the colored torches");
	}
	
	public boolean isValid()
	{
		return (this.craftingItem != null);
	}
}
