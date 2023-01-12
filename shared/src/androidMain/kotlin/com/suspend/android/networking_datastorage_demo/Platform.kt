package com.suspend.android.networking_datastorage_demo

import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.TypeParceler


class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}


actual fun getPlatform(): Platform = AndroidPlatform()

actual typealias CommonParcelize = Parcelize
actual typealias CommonParcelable = Parcelable

actual typealias CommonParceler<T> = Parceler<T>
actual typealias CommonTypeParceler<T,P> = TypeParceler<T, P>


