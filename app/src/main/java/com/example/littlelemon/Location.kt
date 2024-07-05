package com.example.littlelemon

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun LocationScreen() {
    val context = LocalContext.current
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var postalCode by remember { mutableStateOf("") }
    var useManualEntry by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Set Your Location",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row {
            Button(
                onClick = { useManualEntry = true },
                colors = ButtonDefaults.buttonColors(
                    if (useManualEntry) LittleLemonColor.green else Color.LightGray
                ),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Enter Manually")
            }

            Button(
                onClick = { useManualEntry = false },
                colors = ButtonDefaults.buttonColors(
                    if (useManualEntry) Color.LightGray else LittleLemonColor.green
                ),
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Select on Map")
            }
        }

        if (useManualEntry) {
            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("City") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            OutlinedTextField(
                value = postalCode,
                onValueChange = { postalCode = it },
                label = { Text("Postal Code") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Button(
                onClick = {
                    // Handle saving location
                    Toast.makeText(context, "Location saved!", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors(containerColor = LittleLemonColor.green)
            ) {
                Text(
                    text = "Save Location",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        } else {
            GoogleMapView()
        }
    }
}

@Composable
fun GoogleMapView() {
    val context = LocalContext.current
    val mapView = rememberMapViewWithLifecycle()
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    val activity = LocalContext.current as Activity

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return@rememberLauncherForActivityResult
            }
            fusedLocationClient.lastLocation.addOnSuccessListener { location: android.location.Location? ->
                location?.let {
                    mapView.getMapAsync { googleMap ->
                        val latLng = LatLng(location.latitude, location.longitude)
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
                        googleMap.addMarker(MarkerOptions().position(latLng).title("Current Location"))
                    }
                }
            }
        } else {
            Toast.makeText(context, "Location permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(mapView) {
        launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    AndroidView({ mapView }) { mapView ->
        mapView.getMapAsync { googleMap ->
            googleMap.uiSettings.isZoomControlsEnabled = true
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                googleMap.isMyLocationEnabled = true
            }
        }
    }
}

@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }
    val lifecycleObserver = rememberMapViewLifecycleObserver(mapView)
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle, lifecycleObserver) {
        lifecycle.addObserver(lifecycleObserver)
        onDispose { lifecycle.removeObserver(lifecycleObserver) }
    }
    return mapView
}

@Composable
fun rememberMapViewLifecycleObserver(mapView: MapView): DefaultLifecycleObserver {
    return remember(mapView) {
        object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                mapView.onCreate(null)
            }

            override fun onStart(owner: LifecycleOwner) {
                mapView.onStart()
            }

            override fun onResume(owner: LifecycleOwner) {
                mapView.onResume()
            }

            override fun onPause(owner: LifecycleOwner) {
                mapView.onPause()
            }

            override fun onStop(owner: LifecycleOwner) {
                mapView.onStop()
            }

            override fun onDestroy(owner: LifecycleOwner) {
                mapView.onDestroy()
            }

            fun onLowMemory(owner: LifecycleOwner) {
                mapView.onLowMemory()
            }
        }
    }
}
