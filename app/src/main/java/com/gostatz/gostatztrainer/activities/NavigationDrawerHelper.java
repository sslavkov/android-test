package com.gostatz.gostatztrainer.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import com.gostatz.gostatztrainer.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by sslavkov on 8/19/17.
 */

public class NavigationDrawerHelper {
	
	public static DrawerBuilder getDefaultDrawerBuilder(Activity activity, Toolbar toolbar) {
		// Create the AccountHeader
		Resources resources = activity.getResources();
		Drawable accountIcon = resources.getDrawable(R.drawable.ic_person_black_24dp);
		accountIcon.setTint(resources.getColor(R.color.md_grey_500));
		AccountHeader headerResult = new AccountHeaderBuilder()
											 .withActivity(activity)
											 .withHeaderBackground(R.drawable.side_nav_bar)
											 .withSelectionListEnabled(false) // disables arrow to click
											 .addProfiles(
													 new ProfileDrawerItem()
															 .withName("Mike Penz")
															 .withEmail("mikepenz@gmail.com")
															 .withIcon(accountIcon)
											 )
											 .withOnAccountHeaderListener((view, profile, currentProfile) -> false)
											 .build();
		
		
		return new DrawerBuilder()
						.withActivity(activity)
						.withToolbar(toolbar)
						.withAccountHeader(headerResult)
						.addDrawerItems(getDefaultIDrawerItems(activity))
						.withOnDrawerItemClickListener((view, position, drawerItem) -> {
						
//							if (drawerItem != null) {
//								if (drawerItem instanceof Nameable) {
//									toolbar.setTitle(((Nameable)
//															  drawerItem).getNameRes());
//								}
//							}
							
							return false;
						
						});
	}
	
	@NonNull
	private static IDrawerItem[] getDefaultIDrawerItems(Activity activity) {
		return new IDrawerItem[]{
					new SecondaryDrawerItem()
							.withIcon(R.drawable.ic_group_black_24dp)
							.withName(R.string.navigation_drawer_clients)
							.withIconTintingEnabled(true),
					new SecondaryDrawerItem()
							.withOnDrawerItemClickListener((view, position, drawerItem) -> {
								activity.startActivity(new Intent(activity, BusinessClientInfoActivity.class));
								return false;
							})
							.withIcon(R.drawable.ic_group_black_24dp)
							.withName(R.string.navigation_drawer_clients)
							.withIconTintingEnabled(true),
					new SecondaryDrawerItem()
							.withIcon(R.drawable.ic_add_black_24dp)
							.withName(R.string.last_name)
							.withIconTintingEnabled(true),
					new SecondaryDrawerItem()
							.withIcon(R.drawable.ic_add_black_24dp)
							.withName(R.string.last_name)
							.withIconTintingEnabled(true),
					new SecondaryDrawerItem()
							.withIcon(R.drawable.ic_add_black_24dp)
							.withName(R.string.last_name)
							.withIconTintingEnabled(true),
					new SecondaryDrawerItem()
							.withIcon(R.drawable.ic_add_black_24dp)
							.withName(R.string.last_name)
							.withIconTintingEnabled(true)};
	}
	
}
