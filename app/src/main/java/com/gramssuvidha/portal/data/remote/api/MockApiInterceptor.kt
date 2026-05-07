package com.gramssuvidha.portal.data.remote.api

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import javax.inject.Inject
import javax.inject.Singleton

/**
 * OkHttp Interceptor that returns mock JSON responses,
 * simulating a real Panchayat backend API.
 * Replace with a real base URL when deploying to production.
 */
@Singleton
class MockApiInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath

        val json = when {
            path.contains("/projects") && !path.contains("/updates") -> PROJECTS_JSON
            path.contains("/updates") -> {
                val projectId = path.split("/").getOrNull(path.split("/").indexOf("projects") + 1) ?: ""
                getUpdatesJson(projectId)
            }
            path.contains("/feedback") -> FEEDBACK_RESPONSE_JSON
            else -> """{"success":false,"message":"Unknown endpoint"}"""
        }

        return Response.Builder()
            .code(200)
            .message("OK")
            .protocol(Protocol.HTTP_1_1)
            .request(request)
            .body(json.toResponseBody("application/json".toMediaTypeOrNull()))
            .build()
    }

    private fun getUpdatesJson(projectId: String): String = """
    {
      "success": true,
      "data": [
        {
          "id": "upd_${projectId}_1",
          "project_id": "$projectId",
          "title": "Work Commenced",
          "description": "Foundation work and site clearing completed. Materials procured.",
          "progress_percent": 20,
          "image_url": "https://images.unsplash.com/photo-1504307651254-35680f356dfd?w=600",
          "updated_by": "Site Engineer Kumar",
          "updated_at": 1714003200000
        },
        {
          "id": "upd_${projectId}_2",
          "project_id": "$projectId",
          "title": "Mid-Progress Review",
          "description": "Structural work 60% complete. Quality inspection passed.",
          "progress_percent": 60,
          "image_url": "https://images.unsplash.com/photo-1581094794329-c8112a89af12?w=600",
          "updated_by": "Panchayat Supervisor",
          "updated_at": 1716595200000
        },
        {
          "id": "upd_${projectId}_3",
          "project_id": "$projectId",
          "title": "Final Inspection Pending",
          "description": "Work nearing completion. Final government inspection scheduled.",
          "progress_percent": 90,
          "image_url": "https://images.unsplash.com/photo-1590608897129-79da98d15969?w=600",
          "updated_by": "Block Development Officer",
          "updated_at": 1719273600000
        }
      ]
    }
    """.trimIndent()

    companion object {
        val FEEDBACK_RESPONSE_JSON = """{"success":true,"message":"Feedback submitted successfully."}"""

        val PROJECTS_JSON = """
        {
          "success": true,
          "total": 10,
          "data": [
            {
              "id": "proj_001",
              "title": "Main Village Road Resurfacing",
              "description": "Complete resurfacing and widening of the 3.2 km main village road connecting the panchayat office to the national highway. Includes drainage channels and footpaths.",
              "category": "ROAD",
              "status": "IN_PROGRESS",
              "budget": 4500000.0,
              "budget_spent": 2800000.0,
              "progress_percent": 62,
              "contractor": "Sri Lakshmi Constructions Pvt Ltd",
              "contractor_contact": "+91-9845001234",
              "start_date": "2024-01-15",
              "expected_completion": "2024-08-30",
              "actual_completion": null,
              "location": "Hosur Main Road, Ward 3",
              "latitude": 12.7409,
              "longitude": 77.8253,
              "ward": "Ward 3",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1465447142348-e9952c393450?w=800",
                "https://images.unsplash.com/photo-1449824913935-59a10b8d2000?w=800"
              ],
              "before_images": [
                "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=600"
              ],
              "after_images": [],
              "ai_summary": "Road resurfacing is progressing steadily at 62%. The project is on schedule and expected to improve connectivity for over 2,400 villagers. Current phase focuses on base layer compaction.",
              "last_updated": 1719273600000
            },
            {
              "id": "proj_002",
              "title": "Gram Panchayat Pond Rejuvenation",
              "description": "De-silting, deepening, and bund strengthening of the 4-acre village pond. Includes rain-water harvesting structures and tree plantation along the bund.",
              "category": "ENVIRONMENT",
              "status": "COMPLETED",
              "budget": 1800000.0,
              "budget_spent": 1750000.0,
              "progress_percent": 100,
              "contractor": "Kaveri Water Works",
              "contractor_contact": "+91-9900112233",
              "start_date": "2023-10-01",
              "expected_completion": "2024-02-28",
              "actual_completion": "2024-02-22",
              "location": "Village Tank Road, Ward 1",
              "latitude": 12.7425,
              "longitude": 77.8270,
              "ward": "Ward 1",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1506905925346-21bda4d32df4?w=800"
              ],
              "before_images": [
                "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=600"
              ],
              "after_images": [
                "https://images.unsplash.com/photo-1544551763-46a013bb70d5?w=600"
              ],
              "ai_summary": "Pond rejuvenation has been successfully completed 6 days ahead of schedule. The restored pond now holds 35% more water, significantly improving the village groundwater table for the upcoming summer.",
              "last_updated": 1708560000000
            },
            {
              "id": "proj_003",
              "title": "Government Primary School Renovation",
              "description": "Comprehensive renovation of 6 classrooms, construction of separate boys and girls toilets, drinking water facility, and compound wall repair.",
              "category": "EDUCATION",
              "status": "IN_PROGRESS",
              "budget": 3200000.0,
              "budget_spent": 1100000.0,
              "progress_percent": 35,
              "contractor": "Shri Vinayaka Builders",
              "contractor_contact": "+91-9741234567",
              "start_date": "2024-03-10",
              "expected_completion": "2024-11-30",
              "actual_completion": null,
              "location": "School Road, Ward 2",
              "latitude": 12.7390,
              "longitude": 77.8240,
              "ward": "Ward 2",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1580582932707-520aed937b7b?w=800",
                "https://images.unsplash.com/photo-1503676260728-1c00da094a0b?w=800"
              ],
              "before_images": [
                "https://images.unsplash.com/photo-1517971129774-8a2b38fa128e?w=600"
              ],
              "after_images": [],
              "ai_summary": "School renovation is at 35% completion. Toilet block construction is complete. Classroom plastering work is ongoing. This renovation will benefit 340 students when completed in November.",
              "last_updated": 1719360000000
            },
            {
              "id": "proj_004",
              "title": "Fluoride-Free Borewell & RO Plant",
              "description": "Drilling of 3 bore-wells and installation of Reverse Osmosis water purification plant to provide safe drinking water free of fluoride and nitrates.",
              "category": "WATER",
              "status": "COMPLETED",
              "budget": 2500000.0,
              "budget_spent": 2480000.0,
              "progress_percent": 100,
              "contractor": "AquaSafe Engineering",
              "contractor_contact": "+91-8025678901",
              "start_date": "2023-08-01",
              "expected_completion": "2023-12-31",
              "actual_completion": "2023-12-28",
              "location": "Kere Halli Layout, Ward 4",
              "latitude": 12.7450,
              "longitude": 77.8300,
              "ward": "Ward 4",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1541919329513-35f7af297129?w=800"
              ],
              "before_images": [],
              "after_images": [
                "https://images.unsplash.com/photo-1503427315916-52f2d36c4c4c?w=600"
              ],
              "ai_summary": "The RO water plant is fully operational and serving 520 households. Water quality tests confirm fluoride levels are now within safe limits. Daily capacity: 25,000 litres.",
              "last_updated": 1703721600000
            },
            {
              "id": "proj_005",
              "title": "Underground Drainage System",
              "description": "Installation of 2.8 km underground PVC drainage pipeline connecting all wards to the sewage treatment junction. Eliminates open drains.",
              "category": "SANITATION",
              "status": "DELAYED",
              "budget": 6200000.0,
              "budget_spent": 2900000.0,
              "progress_percent": 45,
              "contractor": "SB Infra Projects",
              "contractor_contact": "+91-9632587410",
              "start_date": "2024-01-01",
              "expected_completion": "2024-06-30",
              "actual_completion": null,
              "location": "All Wards - Village Layout",
              "latitude": 12.7415,
              "longitude": 77.8260,
              "ward": "All Wards",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1504307651254-35680f356dfd?w=800"
              ],
              "before_images": [
                "https://images.unsplash.com/photo-1578662996442-48f60103fc96?w=600"
              ],
              "after_images": [],
              "ai_summary": "This project is currently delayed by 47 days due to monsoon disruptions and underground utility conflicts. The contractor has submitted a revised completion date of September 2024. Progress review meeting scheduled.",
              "last_updated": 1719100800000
            },
            {
              "id": "proj_006",
              "title": "Community Hall Construction",
              "description": "Construction of a 3,000 sq ft multi-purpose community hall with stage, seating capacity for 400, storage room, and an attached kitchen.",
              "category": "COMMUNITY",
              "status": "IN_PROGRESS",
              "budget": 7800000.0,
              "budget_spent": 3500000.0,
              "progress_percent": 48,
              "contractor": "Priya Constructions",
              "contractor_contact": "+91-9845098765",
              "start_date": "2023-12-01",
              "expected_completion": "2024-10-31",
              "actual_completion": null,
              "location": "Panchayat Main Road, Ward 5",
              "latitude": 12.7430,
              "longitude": 77.8245,
              "ward": "Ward 5",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1497366216548-37526070297c?w=800",
                "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=800"
              ],
              "before_images": [],
              "after_images": [],
              "ai_summary": "Community hall construction is progressing at 48%. The roof slab has been cast and curing is underway. Wall plastering and flooring are the next major milestones. The hall will serve as a hub for gram sabhas and cultural events.",
              "last_updated": 1719446400000
            },
            {
              "id": "proj_007",
              "title": "Solar Street Lighting (50 Poles)",
              "description": "Installation of 50 solar-powered LED street lights covering all 6 wards. Each pole includes a 120W panel, 100Ah battery, and motion sensor.",
              "category": "ELECTRICITY",
              "status": "COMPLETED",
              "budget": 1500000.0,
              "budget_spent": 1498000.0,
              "progress_percent": 100,
              "contractor": "SunPower Rural Solutions",
              "contractor_contact": "+91-8012345678",
              "start_date": "2024-02-01",
              "expected_completion": "2024-04-30",
              "actual_completion": "2024-04-18",
              "location": "All Wards",
              "latitude": 12.7400,
              "longitude": 77.8255,
              "ward": "All Wards",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1466611653911-95081537e5b7?w=800"
              ],
              "before_images": [],
              "after_images": [
                "https://images.unsplash.com/photo-1504711434969-e33886168f5c?w=600"
              ],
              "ai_summary": "All 50 solar street lights are operational, completed 12 days ahead of schedule. Night-time visibility has improved significantly, benefiting women's safety and reducing road accidents by an estimated 40%.",
              "last_updated": 1713398400000
            },
            {
              "id": "proj_008",
              "title": "PM Awas Yojana - 25 Housing Units",
              "description": "Construction of 25 permanent houses under Pradhan Mantri Awas Yojana (Gramin) for Below Poverty Line families in the panchayat.",
              "category": "HOUSING",
              "status": "IN_PROGRESS",
              "budget": 5000000.0,
              "budget_spent": 2500000.0,
              "progress_percent": 52,
              "contractor": "Individual Beneficiaries (Self-build)",
              "contractor_contact": "Panchayat Office: +91-8023456789",
              "start_date": "2024-01-20",
              "expected_completion": "2024-09-30",
              "actual_completion": null,
              "location": "Multiple Locations, All Wards",
              "latitude": 12.7418,
              "longitude": 77.8265,
              "ward": "All Wards",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1560518883-ce09059eeffa?w=800"
              ],
              "before_images": [],
              "after_images": [],
              "ai_summary": "PM Awas Yojana housing project is 52% complete with 13 of 25 units reaching roof level. Second installment of ₹60,000 released to eligible beneficiaries. Completion expected by September 2024.",
              "last_updated": 1719532800000
            },
            {
              "id": "proj_009",
              "title": "Farmers' Market & Cold Storage Facility",
              "description": "Construction of a 5,000 sq ft farmers' market yard with 20 stalls, a 10-tonne cold storage unit, and a digital weighing and payment kiosk.",
              "category": "AGRICULTURE",
              "status": "UPCOMING",
              "budget": 9500000.0,
              "budget_spent": 0.0,
              "progress_percent": 0,
              "contractor": "Tender Evaluation Pending",
              "contractor_contact": "Panchayat: +91-8023456789",
              "start_date": "2024-09-01",
              "expected_completion": "2025-06-30",
              "actual_completion": null,
              "location": "Agri Land, Ward 6",
              "latitude": 12.7480,
              "longitude": 77.8310,
              "ward": "Ward 6",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1488459716781-31db52582fe9?w=800"
              ],
              "before_images": [],
              "after_images": [],
              "ai_summary": "This upcoming project will revolutionize agricultural commerce in the village. Tender process is ongoing. Once complete, farmers will save an estimated ₹15,000 per season on transportation and middleman costs.",
              "last_updated": 1719619200000
            },
            {
              "id": "proj_010",
              "title": "Primary Health Sub-Centre Upgrade",
              "description": "Renovation and equipment upgrade of the village sub-centre: new OPD room, delivery room, waiting area, medicine storage, and telemedicine setup.",
              "category": "HEALTH",
              "status": "IN_PROGRESS",
              "budget": 2800000.0,
              "budget_spent": 980000.0,
              "progress_percent": 28,
              "contractor": "HealthBuild Associates",
              "contractor_contact": "+91-9741122334",
              "start_date": "2024-04-01",
              "expected_completion": "2024-12-31",
              "actual_completion": null,
              "location": "Health Sub-Centre Road, Ward 2",
              "latitude": 12.7395,
              "longitude": 77.8235,
              "ward": "Ward 2",
              "panchayat_name": "Ketaganahalli Gram Panchayat",
              "image_urls": [
                "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=800"
              ],
              "before_images": [
                "https://images.unsplash.com/photo-1519494026892-80bbd2d6fd0d?w=600"
              ],
              "after_images": [],
              "ai_summary": "Health sub-centre upgrade is at 28% completion. The new OPD foundation is laid and tiling has started. The telemedicine equipment has been procured. This upgrade will serve over 3,200 villagers with better healthcare access.",
              "last_updated": 1719705600000
            }
          ]
        }
        """.trimIndent()
    }
}
