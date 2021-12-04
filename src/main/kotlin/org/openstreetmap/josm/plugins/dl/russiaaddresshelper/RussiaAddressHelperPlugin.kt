package org.openstreetmap.josm.plugins.dl.russiaaddresshelper

import org.openstreetmap.josm.data.Version
import org.openstreetmap.josm.gui.MainApplication
import org.openstreetmap.josm.gui.preferences.PreferenceSetting
import org.openstreetmap.josm.plugins.Plugin
import org.openstreetmap.josm.plugins.PluginInformation
import org.openstreetmap.josm.plugins.dl.russiaaddresshelper.actions.ClickAction
import org.openstreetmap.josm.plugins.dl.russiaaddresshelper.actions.SelectAction
import org.openstreetmap.josm.plugins.dl.russiaaddresshelper.settings.PluginSetting
import org.openstreetmap.josm.tools.I18n
import org.openstreetmap.josm.tools.ImageProvider
import javax.swing.JMenu

class RussiaAddressHelperPlugin(info: PluginInformation) : Plugin(info) {
    init {
        menuInit(MainApplication.getMenu().dataMenu)
        versionInfo = String.format("JOSM/%s JOSM-RussiaAddressHelper/%s", Version.getInstance().versionString, info.version)
    }

    companion object {
        val ACTION_NAME = I18n.tr("Russia address helper")!!
        val ICON_NAME = "icon.svg"

        @JvmStatic lateinit var versionInfo: String
    }

    override fun getPreferenceSetting(): PreferenceSetting {
        return PluginSetting()
    }

    private fun menuInit(menu: JMenu) {
        menu.isVisible = true

        if (menu.itemCount > 0) {
            menu.addSeparator()
        }

        val subMenu = JMenu(ACTION_NAME)
        subMenu.icon = ImageProvider(ICON_NAME).resource.getPaddedIcon(ImageProvider.ImageSizes.SMALLICON.imageDimension)

        subMenu.add(SelectAction())
        subMenu.add(ClickAction())

        menu.add(subMenu)
    }
}