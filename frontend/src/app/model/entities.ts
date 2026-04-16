export interface JobApplication {
    id: number;
    agency: string;
    linkJob: string;
    source: string;
    placementProfileId: number;
}
export interface PlacementProfile {
    id: number;
    name: string;
    description: string;
}
export interface WeekApplication {
    id: number;
    week: number;
    status: string;
    jobApplicationId: number;
}